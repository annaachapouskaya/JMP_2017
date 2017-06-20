package com.epam.achapouskaya;

import java.util.concurrent.ThreadLocalRandom;

public class DummyObject {
	
	private char[] data;
	private long dummyNumber;
	private Object dummyObject;
	
	public DummyObject() {
		super();
	}

	public DummyObject(char[] data, long dummyNumber, Object dummyObject) {
		super();
		this.data = data;
		this.dummyNumber = dummyNumber;
		this.dummyObject = dummyObject;
	}

	public char[] getData() {
		return data;
	}

	public void setData(char[] data) {
		this.data = data;
	}

	public long getDummyNumber() {
		return dummyNumber;
	}

	public void setDummyNumber(long dummyNumber) {
		this.dummyNumber = dummyNumber;
	}

	public Object getDummyObject() {
		return dummyObject;
	}

	public void setDummyObject(Object dummyObject) {
		this.dummyObject = dummyObject;
	}
	
	public static DummyObject generateDummyObject(int min, int max) {
		DummyObject object = new DummyObject();
		object.setDummyNumber(ThreadLocalRandom.current().nextLong());
		object.setData(generateCharArray(min, max));
		return object;
	}

	private static char[] generateCharArray(int min, int max) {
		int sizeOfString = ThreadLocalRandom.current().nextInt(min, max + 1);
		return new char[sizeOfString];
	}
	
	@Override
	protected void finalize() throws Throwable {
	    System.out.println(this + " was collected");
	    super.finalize();
	}
	
}
