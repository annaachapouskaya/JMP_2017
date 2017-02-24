package com.epam.achapouskaya.thread;

public class DummyThreadOne extends Thread {
	
	private Object resourceOne;
	private Object resourceTwo;
	
	public DummyThreadOne(Object resourceOne, Object resourceTwo) {
		super();
		this.resourceOne = resourceOne;
		this.resourceTwo = resourceTwo;
	}

	@Override
	public void run() {
		synchronized (resourceOne) {
			System.out.println("DummyThreadOne locked resourceOne");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("DummyThreadOne tried to get lock for resourceTwo");
			synchronized(resourceTwo) {
				System.out.println("DummyThreadOne locked resourceTwo");
			}
			System.out.println("DummyThreadOne released resourceTwo");
		}
		System.out.println("DummyThreadOne released resourceOne");
	}

}
