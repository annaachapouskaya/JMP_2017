package com.epam.achapouskaya.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 217097603844421562L;
	
	private String id;
	private String username;
	private String email;
	
	public User() {
		super();
	}

	public User(String id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
