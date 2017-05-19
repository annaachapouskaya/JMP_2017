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

	public String create(Dog pet) {
		return dogDAO.create(pet);
	}

	public Dog get(Dog pet) {
		return dogDAO.get(pet.getId());
	}

	public List<Dog> getAll() {
		return dogDAO.getAll();
	}

	public boolean update(Dog pet) {
		return dogDAO.update(pet);
	}

	public boolean delete(Dog pet) {
		return dogDAO.delete(pet.getId());
	}

}
