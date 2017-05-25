package com.epam.achapouskaya.dao.impl.hibernate;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.epam.achapouskaya.dao.BirdDAO;
import com.epam.achapouskaya.model.Bird;

public class HibernateBirdDAOImpl extends HibernateCommonDAO implements BirdDAO {

	@Transactional
	public long create(Bird pet) {
		entityManager.persist(pet);
		return pet.getId();
	}

	public Bird get(long id) {
		return entityManager.find(Bird.class, id);
	}

	public List<Bird> getAll() {
		return entityManager.createNamedQuery(Bird.GET_ALL_BIRDS, Bird.class).getResultList();
	}

	public Bird update(Bird pet) {
		return entityManager.merge(pet);
	}

	public boolean delete(long id) {
		entityManager.remove(id);
		if (entityManager.find(Bird.class, id) == null) {
			return true;
		} else {
			return false;
		}
	}

}
