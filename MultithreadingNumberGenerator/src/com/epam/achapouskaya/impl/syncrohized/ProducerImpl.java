package com.epam.achapouskaya.impl.syncrohized;

import java.util.List;

import com.epam.achapouskaya.NumberGenerator;
import com.epam.achapouskaya.Producer;

public class ProducerImpl extends Producer implements Runnable {

	public ProducerImpl(NumberGenerator generator, List<Integer> buffer) {
		super(generator, buffer);
	}

	@Override
	public int produceNumber() {
		return this.generator.generateNumber();
	}

	@Override
	public void run() {
		while (!generator.genereationIsFinished) {
			synchronized(buffer) {
				int number = produceNumber();
				if (!buffer.contains(number)) {
					this.buffer.add(number);
					System.out.println(Thread.currentThread().getName() + " produced number " + number);
				}
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
