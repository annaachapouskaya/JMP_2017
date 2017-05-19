package com.epam.achapouskaya.dao;

import java.util.List;

import com.epam.achapouskaya.model.Pet;

public interface PetDAO<Entity extends Pet> {
	
	public String create(Entity pet);
	public Entity get(String id);
	public List<Entity> getAll();
	public boolean update(Entity pet);
	public boolean delete(String id);	

}
