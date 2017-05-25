package com.epam.achapouskaya.dao;

import java.util.List;

import com.epam.achapouskaya.model.Pet;

public interface PetDAO<Entity extends Pet> {
	
	public long create(Entity pet);
	public Entity get(long id);
	public List<Entity> getAll();
	public Entity update(Entity pet);
	public boolean delete(long id);	

}
