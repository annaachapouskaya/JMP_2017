package com.epam.achapouskaya.model;

public class Bird extends Pet {

	private static final long serialVersionUID = -2900327751789829188L;
	
	private String breed;
	private boolean isSinging;
	
	public Bird() {
		super();
	}

	public Bird(String id, String name, int age, String history, boolean sex, String breed, boolean isSinging) {
		super(id, name, age, history, sex);
		this.breed = breed;
		this.isSinging = isSinging;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isSinging() {
		return isSinging;
	}

	public void setSinging(boolean isSinging) {
		this.isSinging = isSinging;
	}
	
}
