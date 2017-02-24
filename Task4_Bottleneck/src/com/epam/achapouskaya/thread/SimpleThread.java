package com.epam.achapouskaya.thread;

public class SimpleThread extends Thread{
	private Object resource;
	private String id;
	
	public SimpleThread(Object resource, String id) {
		super();
		this.resource = resource;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Thread " + this.id + " starts execution");
		synchronized (this.resource) {
			System.out.println("Thread " + this.id + " locked resource ");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + this.id + " released resource ");
	}
}
