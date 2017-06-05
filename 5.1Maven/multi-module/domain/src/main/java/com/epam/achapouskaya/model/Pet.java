package com.epam.achapouskaya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PET")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Pet implements Serializable{

	private static final long serialVersionUID = -2736203029123445127L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
	private long id;
	
	@Column(name = "NAME")
	@NotEmpty(message = "Please enter name")
	@Size(min = 2, max = 20, message = "Please enter valid name")
	private String name;
	
	@Column(name = "AGE")
	@NotNull
	private int age;
	
	@Column(name = "HISTORY")
	private String history;
	
	@Column(name = "SEX")
	@NotNull
	private boolean sex;
	
	public Pet() {
		super();
	}

	public Pet(long id, String name, int age, String history, boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.history = history;
		this.sex = sex;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
}
