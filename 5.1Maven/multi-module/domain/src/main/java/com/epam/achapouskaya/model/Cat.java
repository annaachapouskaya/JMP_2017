package com.epam.achapouskaya.model;

public class Cat extends Pet {

	private static final long serialVersionUID = -4034088692908748044L;
	
	private WoolLength woolLength;
	private String breed;
	private String character;
	
	public Cat() {
		super();
	}

	public Cat(String id, String name, int age, String history, boolean sex, WoolLength woolLength, String breed,
			String character) {
		super(id, name, age, history, sex);
		this.woolLength = woolLength;
		this.breed = breed;
		this.character = character;
	}



	public WoolLength getWoolLength() {
		return woolLength;
	}

	public void setWoolLength(WoolLength woolLength) {
		this.woolLength = woolLength;
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
