package com.epam.achapouskaya;

import com.epam.achapouskaya.thread.SimpleThread;
import com.epam.achapouskaya.thread.SlowThread;

public class Main {
	private static Object resource = new Object();

	public static void main(String[] args) {
		Thread slowThread = new SlowThread(resource);
		
		int threadCount = 10;
		SimpleThread[] simpleThreads = new SimpleThread[threadCount];
		
		for (int i = 0; i < threadCount; i++) {
			simpleThreads[i] = new SimpleThread(resource, "thr" + i);
		}
		
		slowThread.start();
		for (int i = 0; i < threadCount; i++) {
			simpleThreads[i].start();
		}
	}

}
