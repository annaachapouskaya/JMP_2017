package com.epam.achapouskaya;

import java.util.List;

public abstract class Producer {
	
	protected NumberGenerator generator;
	protected List<Integer> buffer;
		
	public Producer(NumberGenerator generator, List<Integer> buffer) {
		super();
		this.generator = generator;
		this.buffer = buffer;
	}

	public abstract int produceNumber();
	
}
