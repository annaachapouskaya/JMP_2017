package com.epam.achapouskaya.service.impl;

import java.util.List;

import com.epam.achapouskaya.dao.CatDAO;
import com.epam.achapouskaya.model.Cat;
import com.epam.achapouskaya.service.CatService;

public class CatServiceImpl implements CatService {
	
private CatDAO catDAO;
	
	public CatDAO getCatDAO() {
		return catDAO;
	}

	public void setCatDAO(CatDAO catDAO) {
		this.catDAO = catDAO;
	}

	public String create(Cat pet) {
		return catDAO.create(pet);
	}

	public Cat get(Cat pet) {
		return catDAO.get(pet.getId());
	}

	public List<Cat> getAll() {
		return catDAO.getAll();
	}

	public boolean update(Cat pet) {
		return catDAO.update(pet);
	}

	public boolean delete(Cat pet) {
		return catDAO.delete(pet.getId());
	}



}
