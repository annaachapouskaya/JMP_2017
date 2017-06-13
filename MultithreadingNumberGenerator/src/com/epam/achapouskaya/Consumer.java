package com.epam.achapouskaya;

import java.io.File;
import java.io.Writer;
import java.util.List;

public abstract class Consumer {

	protected List<Integer> buffer;
	protected Writer writer;
	protected File file;

	public Consumer(List<Integer> buffer, Writer writer) {
		super();
		this.buffer = buffer;
		this.writer = writer;
	}
	
	public Consumer(List<Integer> buffer, File file) {
		super();
		this.buffer = buffer;
		this.file = file;
	}

	public abstract void consumeNumber();

}
