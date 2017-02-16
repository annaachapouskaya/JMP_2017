package com.epam.achapouskaya.thread;


public class SlowThread extends Thread{
	private Object resource;
	
	public SlowThread(Object resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		System.out.println("SlowThread starts execution");
		synchronized (this.resource) {
			System.out.println("SlowThread locked resource ");
			try {
				Thread.sleep(1000000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("SlowThread released resource ");
	}
}
