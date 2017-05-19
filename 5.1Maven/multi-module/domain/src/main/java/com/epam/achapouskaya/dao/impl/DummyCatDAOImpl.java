package com.epam.achapouskaya.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.achapouskaya.dao.CatDAO;
import com.epam.achapouskaya.model.Cat;
import com.epam.achapouskaya.model.WoolLength;

public class DummyCatDAOImpl implements CatDAO {
	
	private static Map<String, Cat> cats;
	
	public static void init() {
		cats = new HashMap<String, Cat>();
		Cat cat1 = new Cat("cat1", "Vasya", 6, "Was found near vine shop in Minsk", false, WoolLength.MEDIUM, "unknown",
				"playful");
		Cat cat2 = new Cat("cat2", "Alisa", 3, "Young cat lady", true, WoolLength.LONG, "persian",
				"high-minded");
		cats.put(cat1.getId(), cat1);
		cats.put(cat2.getId(), cat2);
	}

	public String create(Cat pet) {
		pet.setId("cat" + System.currentTimeMillis());
		cats.put(pet.getId(), pet);
		return pet.getId();
	}

	public Cat get(String id) {
		return cats.get(id);
	}

	public List<Cat> getAll() {
		return new ArrayList<Cat>(cats.values());
	}

	public boolean update(Cat pet) {
		if (cats.get(pet.getId()) != null) {
			cats.put(pet.getId(), pet);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(String id) {
		if (cats.remove(id) != null) {
			return true;
		} else {
			return false;
		}
	}

}
