package com.epam.achapouskaya;

import java.util.List;

public abstract class Consumer {

	protected List<Integer> buffer;
	
	protected String fileName;

	public Consumer(List<Integer> buffer, String fileName) {
		super();
		this.buffer = buffer;
		this.fileName = fileName;
	}

	public abstract void consumeNumber();

}
