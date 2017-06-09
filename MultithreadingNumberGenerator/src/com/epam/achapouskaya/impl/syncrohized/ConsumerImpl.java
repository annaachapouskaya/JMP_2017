package com.epam.achapouskaya.impl.syncrohized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.epam.achapouskaya.Consumer;

public class ConsumerImpl extends Consumer implements Runnable {

	private boolean isRunning = true;
	
	public ConsumerImpl(List<Integer> buffer, String fileName) {
		super(buffer, fileName);
	}

	@Override
	public void consumeNumber() {
		synchronized (buffer) {
			if (this.buffer != null && !this.buffer.isEmpty()) {
				int number = this.buffer.get(0);
				// System.out.println("Number " + number + " was consumed");
				String msg = "Number " + number + " was consumed\n";
				try {
					Files.write(Paths.get(this.fileName), msg.getBytes(), StandardOpenOption.APPEND);
					this.buffer.remove((Integer) number);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void run() {
		while (this.isRunning) {
			consumeNumber();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Stopping consumer " + Thread.currentThread().getName());
	}
	
	public void stopConsuming() {
		this.isRunning = false;
	}

}
