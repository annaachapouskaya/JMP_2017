package com.epam.achapouskaya.thread;

import com.epam.achapouskaya.resource.Resource;

public class SimpleThread extends Thread {
	private Resource resource;
	private String id;
	
	public SimpleThread(Resource resource, String id) {
		super();
		this.resource = resource;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Thread " + this.id + " starts execution");
		synchronized (this.resource) {
			System.out.println("Thread " + this.id + " locked resource " + this.resource.getId());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + this.id + " released resource " + this.resource.getId());
	}
}
