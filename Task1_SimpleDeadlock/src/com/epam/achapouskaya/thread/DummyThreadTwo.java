package com.epam.achapouskaya.thread;

public class DummyThreadTwo extends Thread {
	
	private Object resourceOne;
	private Object resourceTwo;
	
	public DummyThreadTwo(Object resourceOne, Object resourceTwo) {
		super();
		this.resourceOne = resourceOne;
		this.resourceTwo = resourceTwo;
	}

	@Override
	public void run() {
		synchronized (resourceTwo) {
			System.out.println("DummyThreadTwo locked resourceTwo");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("DummyThreadTwo tried to get lock for resourceOne");
			synchronized(resourceOne) {
				System.out.println("DummyThreadTwo locked resourceOne");
			}
			System.out.println("DummyThreadTwo released resourceOne");
		}
		System.out.println("DummyThreadTwo released resourceTwo");
	}

}
