package com.epam.achapouskaya;

import com.epam.achapouskaya.resource.Resource;
import com.epam.achapouskaya.thread.DummyThreadOne;
import com.epam.achapouskaya.thread.DummyThreadTwo;
import com.epam.achapouskaya.thread.SimpleThread;

public class Main {

	private static Resource resourceOne = new Resource("res1");
	private static Resource resourceTwo = new Resource("res2");

	public static void main(String[] args) {
		Thread threadOne = new DummyThreadOne(resourceOne, resourceTwo);
		Thread threadTwo = new DummyThreadTwo(resourceOne, resourceTwo);
		
		Thread thread3 = new SimpleThread(resourceOne, "thr3");
		Thread thread4 = new SimpleThread(resourceOne, "thr4");
		Thread thread5 = new SimpleThread(resourceOne, "thr5");
		
		Thread thread6 = new SimpleThread(resourceTwo, "thr6");
		Thread thread7 = new SimpleThread(resourceTwo, "thr7");
		Thread thread8 = new SimpleThread(resourceTwo, "thr8");
		
		threadOne.start();
		threadTwo.start();
		
		thread3.start();
		thread4.start();
		thread5.start();
		
		thread6.start();
		thread7.start();
		thread8.start();


	}
}
