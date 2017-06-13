package com.epam.achapouskaya.impl.syncrohized;

import com.epam.achapouskaya.NumberGenerator;

public class NumberGeneratorImpl extends NumberGenerator  {
	private int count;

	public int getCount() {
		return count;
	}

	@Override
	public int generateNumber() {
		return this.count++;
	}
}
