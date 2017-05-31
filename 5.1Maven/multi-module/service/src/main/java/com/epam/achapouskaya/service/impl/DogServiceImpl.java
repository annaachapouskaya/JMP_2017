package com.epam.achapouskaya.service.impl;

import java.util.List;

import com.epam.achapouskaya.dao.DogDAO;
import com.epam.achapouskaya.model.Dog;
import com.epam.achapouskaya.service.DogService;

public class DogServiceImpl implements DogService {
	
	private DogDAO dogDAO;
	
	public DogDAO getDogDAO() {
		return dogDAO;
	}

	public void setDogDAO(DogDAO dogDAO) {
		this.dogDAO = dogDAO;
	}

	public Dog create(Dog pet) {
		if (pet != null) {
			pet.setId(dogDAO.create(pet));
		}
		return pet;
	}

	public Dog get(Dog pet) {
		return dogDAO.get(pet.getId());
	}

	public List<Dog> getAll() {
		return dogDAO.getAll();
	}

	public Dog update(Dog pet) {
		if (pet != null) {
			pet = dogDAO.update(pet);
		}
		return pet;
	}

	public boolean delete(Dog pet) {
		if (pet != null) {
			return dogDAO.delete(pet.getId());
		}
		return false;
	}

}
