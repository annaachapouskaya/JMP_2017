package com.epam.achapouskaya;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.epam.achapouskaya.impl.syncrohized.ConsumerImpl;
import com.epam.achapouskaya.impl.syncrohized.NumberGeneratorImpl;
import com.epam.achapouskaya.impl.syncrohized.ProducerImpl;

public class Main {
	private static final String FILE_NAME = "output.txt";

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Files.write(Paths.get(FILE_NAME), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
	
		NumberGeneratorImpl generator = new NumberGeneratorImpl();
		List<Integer> buffer = new LinkedList<Integer>();

		runProducers(3, generator, buffer);
		PrintWriter writer = createWriter();
		List<ConsumerImpl> consumers = runConsumers(6, buffer, writer);
		
		while (!generator.genereationIsFinished) {
			System.out.println("Waiting for all values being generated");
			Thread.sleep(1000);
		}
		stopConsumers(consumers);
		writer.close();

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

	private static List<ConsumerImpl> runConsumers(int m, List<Integer> buffer, PrintWriter writer) {
		List<ConsumerImpl> consumers = new ArrayList<ConsumerImpl>(m);
		for (int i = 0; i < m; i++) {
			ConsumerImpl consumer = new ConsumerImpl(buffer, writer);
			consumers.add(consumer);
			Thread threadCons = new Thread(consumer, "ConsumerThread-" + i);
			threadCons.start();
		}
		return consumers;
	}

	private static void stopConsumers(List<ConsumerImpl> consumers) {
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
