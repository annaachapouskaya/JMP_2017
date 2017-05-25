package com.epam.achapouskaya.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DOG")
@DiscriminatorValue(value = "dog")
@NamedQueries({
	@NamedQuery(name = Dog.GET_ALL_DOGS, query = "select d from Dog d")
})
public class Dog extends Pet {
	
	public static final String GET_ALL_DOGS = "getAllDogs";

	private static final long serialVersionUID = -3612788887032611049L;
	
	@Column(name = "BREED")
	@NotNull
	private String breed;
	
	@Column(name = "CHARACTER")
	private String character;
	
	public Dog() {
		super();
	}

	public Dog(long id, String name, int age, String history, boolean sex, String breed, String character) {
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
