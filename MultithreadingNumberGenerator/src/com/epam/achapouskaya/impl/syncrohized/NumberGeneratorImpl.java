package com.epam.achapouskaya.impl.syncrohized;

import com.epam.achapouskaya.NumberGenerator;

public class NumberGeneratorImpl extends NumberGenerator implements Runnable {

	private int count;

	public int getCount() {
		return count;
	}

	@Override
	public int generateNumber() {
		return this.count++;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 500; i++) {
				generateNumber();
				Thread.sleep(10);
			}
			this.genereationIsFinished = true;
			System.out.println("Generation is finshed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
