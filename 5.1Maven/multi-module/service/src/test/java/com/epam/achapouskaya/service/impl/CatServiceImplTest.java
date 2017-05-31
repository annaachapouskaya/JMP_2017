package com.epam.achapouskaya.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import static org.unitils.reflectionassert.ReflectionAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.achapouskaya.dao.CatDAO;
import com.epam.achapouskaya.model.Cat;

@RunWith(MockitoJUnitRunner.class)
public class CatServiceImplTest {
	CatServiceImpl catService;

	@Mock
	CatDAO catDAO;

	@Before
	public void setUp() {
		System.out.println("Before Test");
		catService = new CatServiceImpl();
		catService.setCatDAO(catDAO);
	}

	@After
	public void tearDown() {
		System.out.println("After Test");
		catDAO = null;
		catService = null;
	}

	@Test
	public void createCatWithNullShouldReturnNull() {
		assertNull(catService.create(null));
		verifyZeroInteractions(catDAO);
	}

	@Test
	public void createCatWithCatShouldReturnTheSameCat() {
		Cat cat = createTestCat();
		when(catDAO.create(cat)).thenReturn(cat.getId());
		assertEquals(cat, catService.create(cat));
		verify(catDAO, times(1)).create(cat);
	}

	@Test
	public void updateCatWithNullShouldReturnNull() {
		assertNull(catService.update(null));
		verifyZeroInteractions(catDAO);
	}

	@Test
	public void updateCatShouldReturnUpdatedCat() {
		Cat oldCat = createTestCat();
		Cat updatedCat = createTestCat();
		updatedCat.setName("Updated name");
		when(catDAO.update(oldCat)).thenReturn(updatedCat);
		assertReflectionEquals(updatedCat, catService.update(oldCat));
		verify(catDAO, times(1)).update(oldCat);
	}

	@Test
	public void updateCatShouldntChangeCatId() {
		Long id = (long) 777;
		Cat oldCat = createTestCat();
		oldCat.setId(id);
		Cat updatedCat = createTestCat();
		updatedCat.setId(id);
		updatedCat.setName("Updated name");
		when(catDAO.update(oldCat)).thenReturn(updatedCat);
		assertEquals(id, catService.update(oldCat).getId(), 0);
	}

	@Test
	public void deleteNullShouldntDeleteAnything() {
		assertFalse(catService.delete(null));
		verifyZeroInteractions(catDAO);
	}

	@Test
	public void deleteShouldDeleteOnlyDeletedItem() {
		Cat cat = createTestCat();
		when(catDAO.delete(cat.getId())).thenReturn(true);
		assertTrue(catService.delete(cat));
		verify(catDAO, times(1)).delete(cat.getId());
		verifyNoMoreInteractions(catDAO);
	}

	@Test
	public void getAllShouldReturnAllElementsFromDAO() {
		List<Cat> allCats = createTestCatsList();
		when(catDAO.getAll()).thenReturn(allCats);
		List<Cat> actualAllCats = catService.getAll();
		assertTrue(actualAllCats.containsAll(allCats) && allCats.containsAll(actualAllCats));
		assertEquals(allCats.size(), actualAllCats.size(), 0);

	}

	@Test
	public void getShouldReturnCorrectCat() {
		Cat cat = createTestCat();
		when(catDAO.get(cat.getId())).thenReturn(cat);
		assertReflectionEquals(cat, catService.get(cat));
		verify(catDAO, times(1)).get(cat.getId());
	}

	private Cat createTestCat() {
		Cat cat = new Cat();
		cat.setAge(10);
		cat.setBreed("pinguin");
		cat.setHistory("Some history");
		cat.setId(1234);
		cat.setName("Charly");
		cat.setSex(false);
		return cat;
	}

	private List<Cat> createTestCatsList() {
		List<Cat> cats = new ArrayList<Cat>(10);
		for (int i = 0; i < 10; i++) {
			Cat cat = createTestCat();
			cat.setId(i);
			cats.add(cat);
		}
		return cats;
	}

}
