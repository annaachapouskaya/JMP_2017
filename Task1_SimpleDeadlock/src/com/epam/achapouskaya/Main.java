package com.epam.achapouskaya;

import com.epam.achapouskaya.thread.DummyThreadOne;
import com.epam.achapouskaya.thread.DummyThreadTwo;

public class Main {
	private static Object resourceOne = new Object();
	private static Object resourceTwo = new Object();

	public static void main(String[] args) {
		Thread threadOne = new DummyThreadOne(resourceOne, resourceTwo);
		Thread threadTwo = new DummyThreadTwo(resourceOne, resourceTwo);
		
		threadOne.start();
		threadTwo.start();


	}

}
