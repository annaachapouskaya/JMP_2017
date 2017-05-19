package com.epam.achapouskaya.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.achapouskaya.dao.DogDAO;
import com.epam.achapouskaya.model.Dog;

public class DummyDogDAIOImpl implements DogDAO {
	private static Map<String, Dog> dogs;
	
	public static void init() {
		dogs = new HashMap<String, Dog>();
		Dog dog1 = new Dog();
		dog1.setAge(10);
		dog1.setBreed("unlnown");
		dog1.setCharacter("Charmy");
		dog1.setHistory("Some dog history");
		dog1.setId("dog517");
		dog1.setName("Ravchik");
		dog1.setSex(false);
		
		Dog dog2 = new Dog();
		dog2.setAge(5);
		dog2.setBreed("Shibu Inu");
		dog2.setCharacter("Angry");
		dog2.setHistory("He is like Hatiko");
		dog2.setId("dog1743");
		dog2.setName("Klaus");
		dog2.setSex(false);

		dogs.put(dog1.getId(), dog1);
		dogs.put(dog2.getId(), dog2);
	}


	public String create(Dog pet) {
		dogs.put(pet.getId(), pet);
		return pet.getId();
	}

	public Dog get(String id) {
		return dogs.get(id);
	}

	public List<Dog> getAll() {
		return new ArrayList<Dog>(dogs.values());
	}

	public boolean update(Dog pet) {
		if (dogs.get(pet.getId()) != null) {
			dogs.put(pet.getId(), pet);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(String id) {
		if (dogs.remove(id) != null) {
			return true;
		} else {
			return false;
		}
	}

}
