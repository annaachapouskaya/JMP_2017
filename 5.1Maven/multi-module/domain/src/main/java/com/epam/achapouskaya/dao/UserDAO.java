package com.epam.achapouskaya.dao;

import java.util.List;

import com.epam.achapouskaya.model.User;

public interface UserDAO {
	
	public String create(User user);
	public User get(String id);
	public List<User> getAll();
	public boolean update(User user);
	public boolean delete(String id);	
}
