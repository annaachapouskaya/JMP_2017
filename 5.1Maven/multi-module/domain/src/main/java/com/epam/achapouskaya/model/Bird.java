package com.epam.achapouskaya.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BIRD")
@DiscriminatorValue(value = "bird")
@NamedQueries({
	@NamedQuery(name = Bird.GET_ALL_BIRDS, query = "select b from Bird b")
})
public class Bird extends Pet {
	
	public static final String GET_ALL_BIRDS = "getAllBirds";

	private static final long serialVersionUID = -2900327751789829188L;
	
	@Column(name = "BREED")
	@NotNull
	private String breed;
	
	@Column(name = "IS_SINGING")
	@NotNull
	private boolean isSinging;
	
	public Bird() {
		super();
	}

	public Bird(long id, String name, int age, String history, boolean sex, String breed, boolean isSinging) {
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
