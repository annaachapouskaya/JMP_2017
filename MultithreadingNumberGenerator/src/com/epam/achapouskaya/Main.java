package com.epam.achapouskaya;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.epam.achapouskaya.impl.syncrohized.ConsumerConcurrentListImpl;
import com.epam.achapouskaya.impl.syncrohized.ConsumerSynchronizedImpl;
import com.epam.achapouskaya.impl.syncrohized.NumberGeneratorImpl;
import com.epam.achapouskaya.impl.syncrohized.ProducerImpl;

public class Main {
	private static final String FILE_NAME = "output.txt";

	public static void main(String[] args) throws InterruptedException, IOException {
		runSychronizedSolution();
		//runConcurrentCollectionSolution();

	}
	
	private static void runSychronizedSolution() throws InterruptedException {
		NumberGeneratorImpl generator = new NumberGeneratorImpl();
		List<Integer> buffer = new LinkedList<Integer>();

		runProducers(3, generator, buffer);
		PrintWriter writer = createWriter();
		List<ConsumerSynchronizedImpl> consumers = runConsumers(6, buffer, writer);
		
		while (!generator.genereationIsFinished) {
			System.out.println("Waiting for all values being generated");
			Thread.sleep(1000);
		}
		stopConsumers(consumers);
		writer.close();
	}
	
	private static void runConcurrentCollectionSolution() throws InterruptedException {
		List<Integer> buffer = new LinkedList<Integer>();

		NumberGeneratorImpl generator = new NumberGeneratorImpl();
		runProducers(5, generator, buffer);
		
		List<String> consumersBuffer =  new CopyOnWriteArrayList<String>();
		//List<String> consumersBuffer =  new ArrayList<String>();
		
		List<ConsumerConcurrentListImpl> consumers = runConsumers(6, buffer, consumersBuffer);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Waiting for all values being generated");
			Thread.sleep(1000);
			i++;
		}
		consumers.forEach(consumer -> {
			consumer.stopConsuming();
		});
		
		generator.genereationIsFinished = true;
		
		consumersBuffer.forEach(item -> {
			try {
				Files.write(Paths.get(FILE_NAME), item.getBytes(), StandardOpenOption.APPEND);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

	private static List<ProducerImpl> runProducers(int n, NumberGeneratorImpl generator, List<Integer> buffer) {
		List<ProducerImpl> producers = new ArrayList<ProducerImpl>(n);
		for (int i = 0; i < n; i++) {
			ProducerImpl producer = new ProducerImpl(generator, buffer);
			producers.add(producer);
			Thread threadPr = new Thread(producer, "ProducerThread-" + i);
			threadPr.start();
		}
		return producers;
	}

	private static List<ConsumerSynchronizedImpl> runConsumers(int m, List<Integer> buffer, PrintWriter writer) {
		List<ConsumerSynchronizedImpl> consumers = new ArrayList<ConsumerSynchronizedImpl>(m);
		for (int i = 0; i < m; i++) {
			ConsumerSynchronizedImpl consumer = new ConsumerSynchronizedImpl(buffer, writer);
			consumers.add(consumer);
			Thread threadCons = new Thread(consumer, "ConsumerThread-" + i);
			threadCons.start();
		}
		return consumers;
	}
	
	private static List<ConsumerConcurrentListImpl> runConsumers(int m, List<Integer> buffer, List<String> consumersBuffer) {
		List<ConsumerConcurrentListImpl> consumers = new ArrayList<ConsumerConcurrentListImpl>();
		for (int i = 0; i < m; i++) {
			ConsumerConcurrentListImpl consumer = new ConsumerConcurrentListImpl(buffer, consumersBuffer);
			consumers.add(consumer);
			Thread threadCons = new Thread(consumer, "ConsumerThread-" + i);
			threadCons.start();
		}
		return consumers;
	}

	private static void stopConsumers(List<ConsumerSynchronizedImpl> consumers) {
		System.out.println("Stopping consumers");
		consumers.forEach(consumer -> {
			consumer.stopConsuming();
		});
	}
	
	
	private static PrintWriter createWriter() {
		File f = new File(FILE_NAME);
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}
		
}
