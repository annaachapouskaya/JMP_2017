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

	public Bird create(Bird pet) {
		if (pet != null) {
			pet.setId(birdDAO.create(pet));
		}
		return pet;
	}

	public Bird get(Bird pet) {
		return birdDAO.get(pet.getId());
	}

	public List<Bird> getAll() {
		return birdDAO.getAll();
	}

	public Bird update(Bird pet) {
		if (pet != null) {
			pet = birdDAO.update(pet);
		}
		return pet;
	}

	public boolean delete(Bird pet) {
		if (pet != null) {
			return birdDAO.delete(pet.getId());
		}
		return false;
	}

}
