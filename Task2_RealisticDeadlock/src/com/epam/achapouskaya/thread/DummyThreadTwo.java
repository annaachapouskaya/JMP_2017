package com.epam.achapouskaya.thread;

import com.epam.achapouskaya.resource.Resource;

public class DummyThreadTwo extends Thread{
	private Resource resourceOne;
	private Resource resourceTwo;
	
	public DummyThreadTwo(Resource resourceOne, Resource resourceTwo) {
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
