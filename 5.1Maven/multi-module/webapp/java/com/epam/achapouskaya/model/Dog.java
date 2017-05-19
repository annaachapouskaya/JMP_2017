package com.epam.achapouskaya.model;

public class Dog extends Pet {

	private static final long serialVersionUID = -3612788887032611049L;
	
	private String breed;
	private String character;
	
	public Dog() {
		super();
	}

	public Dog(String id, String name, int age, String history, boolean sex, String breed, String character) {
		super(id, name, age, history, sex);
		this.breed = breed;
		this.character = character;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
		
}
