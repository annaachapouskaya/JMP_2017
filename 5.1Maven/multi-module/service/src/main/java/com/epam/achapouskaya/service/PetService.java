package com.epam.achapouskaya.service;

import java.util.List;

import com.epam.achapouskaya.model.Pet;

public interface PetService <Entity extends Pet> {
	
	public Entity create(Entity pet);
	public Entity get(Entity pet);
	public List<Entity> getAll();
	public Entity update(Entity pet);
	public boolean delete(Entity pet);	


}
