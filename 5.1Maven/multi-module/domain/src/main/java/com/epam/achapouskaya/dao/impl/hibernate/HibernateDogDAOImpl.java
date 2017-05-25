package com.epam.achapouskaya.dao.impl.hibernate;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.epam.achapouskaya.dao.DogDAO;
import com.epam.achapouskaya.model.Dog;

public class HibernateDogDAOImpl extends HibernateCommonDAO implements DogDAO {

	@Transactional
	public long create(Dog pet) {
		entityManager.persist(pet);
		return pet.getId();
	}

	public Dog get(long id) {
		return entityManager.find(Dog.class, id);
	}

	public List<Dog> getAll() {
		return entityManager.createNamedQuery(Dog.GET_ALL_DOGS, Dog.class).getResultList();
	}

	public Dog update(Dog pet) {
		return entityManager.merge(pet);
	}

	public boolean delete(long id) {
		entityManager.remove(id);
		if (entityManager.find(Dog.class, id) == null) {
			return true;
		} else {
			return false;
		}
	}

}
