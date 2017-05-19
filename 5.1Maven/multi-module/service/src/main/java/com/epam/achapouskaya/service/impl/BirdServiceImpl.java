package com.epam.achapouskaya.service.impl;

import java.util.List;

import com.epam.achapouskaya.dao.BirdDAO;
import com.epam.achapouskaya.model.Bird;
import com.epam.achapouskaya.service.BirdService;

public class BirdServiceImpl implements BirdService {
	
	private BirdDAO birdDAO;
	
	public BirdDAO getBirdDAO() {
		return birdDAO;
	}

	public void setBirdDAO(BirdDAO birdDAO) {
		this.birdDAO = birdDAO;
	}

	public String create(Bird pet) {
		return birdDAO.create(pet);
	}

	public Bird get(Bird pet) {
		return birdDAO.get(pet.getId());
	}

	public List<Bird> getAll() {
		return birdDAO.getAll();
	}

	public boolean update(Bird pet) {
		return birdDAO.update(pet);
	}

	public boolean delete(Bird pet) {
		return birdDAO.delete(pet.getId());
	}

}
