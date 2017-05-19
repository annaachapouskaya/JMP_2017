package com.epam.achapouskaya.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.achapouskaya.dao.BirdDAO;
import com.epam.achapouskaya.model.Bird;


public class DummyBirdDAOImpl implements BirdDAO {
	private static Map<String, Bird> birds;
	
	public static void init() {
		birds = new HashMap<String, Bird>();
		Bird bird1 = new Bird();
		bird1.setAge(2);
		bird1.setBreed("Pigeotto");
		bird1.setHistory("It' a pokemon bird");
		bird1.setId("bird1751");
		bird1.setName("Koko");
		bird1.setSex(true);
		bird1.setSinging(true);
		
		Bird bird2 = new Bird();
		bird2.setAge(3);
		bird2.setBreed("Duck");
		bird2.setHistory("A duck from Svicloch");
		bird2.setId("bird1753");
		bird2.setName("Utkative");
		bird2.setSex(false);
		bird2.setSinging(false);


		birds.put(bird1.getId(), bird1);
		birds.put(bird2.getId(), bird2);
	}

	public String create(Bird pet) {
		pet.setId("bird" + System.currentTimeMillis());
		birds.put(pet.getId(), pet);
		return pet.getId();
	}

	public Bird get(String id) {
		return birds.get(id);
	}

	public List<Bird> getAll() {
		return new ArrayList<Bird>(birds.values());
	}

	public boolean update(Bird pet) {
		if (birds.get(pet.getId()) != null) {
			birds.put(pet.getId(), pet);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(String id) {
		if (birds.remove(id) != null) {
			return true;
		} else {
			return false;
		}
	}

}
