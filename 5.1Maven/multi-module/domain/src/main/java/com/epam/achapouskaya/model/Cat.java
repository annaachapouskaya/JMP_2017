package com.epam.achapouskaya.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CAT")
@DiscriminatorValue(value = "cat")
@NamedQueries({
	@NamedQuery(name = Cat.GET_ALL_CATS, query = "select c from Cat c")
})
public class Cat extends Pet {
	
	public static final String GET_ALL_CATS = "getAllCats";

	private static final long serialVersionUID = -4034088692908748044L;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "WOOL_LENGTH")
	@NotNull
	private WoolLength woolLength;
	
	@Column(name = "BREED")
	@NotNull
	private String breed;
	
	@Column(name = "CHARACTER")
	private String character;
	
	public Cat() {
		super();
	}

	public Cat(long id, String name, int age, String history, boolean sex, WoolLength woolLength, String breed,
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
