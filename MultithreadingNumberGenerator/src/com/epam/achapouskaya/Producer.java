package com.epam.achapouskaya;

import java.util.List;

import com.epam.achapouskaya.impl.syncrohized.NumberGeneratorImpl;

public abstract class Producer {
	
	protected NumberGeneratorImpl generator;
	protected List<Integer> buffer;
		
	public Producer(NumberGeneratorImpl generator, List<Integer> buffer) {
		super();
		this.generator = generator;
		this.buffer = buffer;
	}

	public abstract int produceNumber();
	
}
