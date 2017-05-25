package com.epam.achapouskaya.dao.impl.hibernate;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.epam.achapouskaya.dao.CatDAO;
import com.epam.achapouskaya.model.Cat;

public class HibernateCatDAOImpl extends HibernateCommonDAO implements CatDAO {

	@Transactional
	public long create(Cat pet) {
		entityManager.persist(pet);
		return pet.getId();
	}

	public Cat get(long id) {
		return entityManager.find(Cat.class, id);
	}

	public List<Cat> getAll() {
		return entityManager.createNamedQuery(Cat.GET_ALL_CATS, Cat.class).getResultList();
	}

	public Cat update(Cat pet) {
		return entityManager.merge(pet);
	}

	public boolean delete(long id) {
		entityManager.remove(id);
		if (entityManager.find(Cat.class, id) == null) {
			return true;
		} else {
			return false;
		}
	}

}
