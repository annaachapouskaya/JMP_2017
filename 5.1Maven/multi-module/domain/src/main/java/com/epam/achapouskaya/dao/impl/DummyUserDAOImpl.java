package com.epam.achapouskaya.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.achapouskaya.dao.UserDAO;
import com.epam.achapouskaya.model.User;

public class DummyUserDAOImpl implements UserDAO{
	
	private static Map<String, User> users;
	
	public static void init() {
		users = new HashMap<String, User>();
		User user1 = new User();
		
		user1.setEmail("admin@mailinator.com");
		user1.setId("user1800");
		user1.setUsername("Admin");
		
		User user2 = new User();
		
		user2.setEmail("simpleuser@mailinator.com");
		user2.setId("user1801");
		user2.setUsername("Simple User");


		users.put(user1.getId(), user1);
		users.put(user2.getId(), user1);
	}

	public String create(User user) {
		users.put(user.getId(), user);
		return user.getId();
	}

	public User get(String id) {
		return users.get(id);
	}

	public List<User> getAll() {
		return new ArrayList<User>(users.values());
	}

	public boolean update(User user) {
		if (users.get(user.getId()) != null) {
			users.put(user.getId(), user);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(String id) {
		if (users.remove(id) != null) {
			return true;
		} else {
			return false;
		}
	}

}
