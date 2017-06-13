package com.epam.achapouskaya.impl.syncrohized;

import java.io.PrintWriter;
import java.util.List;

import com.epam.achapouskaya.Consumer;

public class ConsumerImpl extends Consumer implements Runnable {

	private boolean isRunning = true;

	public ConsumerImpl(List<Integer> buffer, PrintWriter writer) {
		super(buffer, writer);
	}

	@Override
	public void consumeNumber() {
		consumeNumberWriterSynchro();
	}


	private void consumeNumberWriterSynchro() {
		synchronized (this.writer) {
			if (this.buffer != null && !this.buffer.isEmpty()) {
				int number = this.buffer.get(0);
				// System.out.println("Number " + number + " was consumed");
				String msg = "Number " + number + " was consumed\n";
				((PrintWriter) this.writer).printf(msg);
				((PrintWriter) this.writer).flush();
				this.buffer.remove((Integer) number);
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
