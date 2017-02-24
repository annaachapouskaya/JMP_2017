package com.epam.achapouskaya.thread;

import com.epam.achapouskaya.resource.Resource;

public class DummyThreadOne extends Thread{
	private Resource resourceOne;
	private Resource resourceTwo;
	
	public DummyThreadOne(Resource resourceOne, Resource resourceTwo) {
		super();
		this.resourceOne = resourceOne;
		this.resourceTwo = resourceTwo;
	}

	@Override
	public void run() {
		synchronized (this.resourceOne) {
			System.out.println("DummyThreadOne locked resourceOne");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("DummyThreadOne tried to get lock for resourceTwo");
			synchronized(this.resourceTwo) {
				System.out.println("DummyThreadOne locked resourceTwo");
			}
			System.out.println("DummyThreadOne released resourceTwo");
		}
		System.out.println("DummyThreadOne released resourceOne");
	}

}
