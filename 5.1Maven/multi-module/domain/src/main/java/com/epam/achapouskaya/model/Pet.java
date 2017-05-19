package com.epam.achapouskaya.model;

import java.io.Serializable;

public class Pet implements Serializable{

	private static final long serialVersionUID = -2736203029123445127L;
	
	private String id;
	private String name;
	private int age;
	private String history;
	private boolean sex;
	
	public Pet() {
		super();
	}

	public Pet(String id, String name, int age, String history, boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.history = history;
		this.sex = sex;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
