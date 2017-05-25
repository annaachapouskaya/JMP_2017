package com.epam.achapouskaya.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.achapouskaya.dao.CatDAO;
import com.epam.achapouskaya.model.Cat;
import com.epam.achapouskaya.model.WoolLength;

public class DummyCatDAOImpl implements CatDAO {

	private static Map<Long, Cat> cats;

	public static void init() {
		cats = new HashMap<Long, Cat>();
		Cat cat1 = new Cat(456, "Vasya", 6, "Was found near vine shop in Minsk", false, WoolLength.MEDIUM, "unknown",
				"playful");
		Cat cat2 = new Cat(789, "Alisa", 3, "Young cat lady", true, WoolLength.LONG, "persian", "high-minded");
		cats.put(cat1.getId(), cat1);
		cats.put(cat2.getId(), cat2);
	}

	public long create(Cat pet) {
		pet.setId(System.currentTimeMillis());
		cats.put(pet.getId(), pet);
		return pet.getId();
	}

	public Cat get(long id) {
		return cats.get(id);
	}

	public List<Cat> getAll() {
		return new ArrayList<Cat>(cats.values());
	}

	public Cat update(Cat pet) {
		cats.put(pet.getId(), pet);
		return pet;
	}

	public boolean delete(long id) {
		if (cats.remove(id) != null) {
			return true;
		} else {
			return false;
		}
	}

}
