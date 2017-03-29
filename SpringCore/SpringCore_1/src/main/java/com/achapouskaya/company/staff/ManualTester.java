package com.achapouskaya.company.staff;

import java.util.Set;

public class ManualTester extends Employee {
	
	private static final long serialVersionUID = -519025064971770170L;
	
	private Set<String> expertise;

	public ManualTester() {
		super();
	}

	public Set<String> getExpertise() {
		return expertise;
	}

	public void setExpertise(Set<String> expertise) {
		this.expertise = expertise;
	}

	@Override
	public String toString() {
		return super.toString()
				+ "ManualTester [expertise=" + expertise + "]";
	}
	
	
	
}
