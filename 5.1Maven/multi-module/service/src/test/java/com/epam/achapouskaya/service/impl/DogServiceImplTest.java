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

import com.epam.achapouskaya.dao.DogDAO;
import com.epam.achapouskaya.model.Dog;

@RunWith(MockitoJUnitRunner.class)
public class DogServiceImplTest {
	DogServiceImpl dogService;

	@Mock
	DogDAO dogDAO;

	@Before
	public void setUp() {
		System.out.println("Before Test");
		dogService = new DogServiceImpl();
		dogService.setDogDAO(dogDAO);
	}

	@After
	public void tearDown() {
		System.out.println("After Test");
		dogDAO = null;
		dogService = null;
	}

	@Test
	public void createDogWithNullShouldReturnNull() {
		assertNull(dogService.create(null));
		verifyZeroInteractions(dogDAO);
	}

	@Test
	public void createDogWithDogShouldReturnTheSameDog() {
		Dog dog = createTestDog();
		when(dogDAO.create(dog)).thenReturn(dog.getId());
		assertEquals(dog, dogService.create(dog));
		verify(dogDAO, times(1)).create(dog);
	}

	@Test
	public void updateDogWithNullShouldReturnNull() {
		assertNull(dogService.update(null));
		verifyZeroInteractions(dogDAO);
	}

	@Test
	public void updateDogShouldReturnUpdatedDog() {
		Dog oldDog = createTestDog();
		Dog updatedDog = createTestDog();
		updatedDog.setName("Updated name");
		when(dogDAO.update(oldDog)).thenReturn(updatedDog);
		assertReflectionEquals(updatedDog, dogService.update(oldDog));
		verify(dogDAO, times(1)).update(oldDog);
	}

	@Test
	public void updateDogShouldntChangeDogId() {
		Long id = (long) 777;
		Dog oldDog = createTestDog();
		oldDog.setId(id);
		Dog updatedDog = createTestDog();
		updatedDog.setId(id);
		updatedDog.setName("Updated name");
		when(dogDAO.update(oldDog)).thenReturn(updatedDog);
		assertEquals(id, dogService.update(oldDog).getId(), 0);
	}

	@Test
	public void deleteNullShouldntDeleteAnything() {
		assertFalse(dogService.delete(null));
		verifyZeroInteractions(dogDAO);
	}

	@Test
	public void deleteShouldDeleteOnlyDeletedItem() {
		Dog dog = createTestDog();
		when(dogDAO.delete(dog.getId())).thenReturn(true);
		assertTrue(dogService.delete(dog));
		verify(dogDAO, times(1)).delete(dog.getId());
		verifyNoMoreInteractions(dogDAO);
	}

	@Test
	public void getAllShouldReturnAllElementsFromDAO() {
		List<Dog> allDogs = createTestDogsList();
		when(dogDAO.getAll()).thenReturn(allDogs);
		List<Dog> actualAllDogs = dogService.getAll();
		assertTrue(actualAllDogs.containsAll(allDogs) && allDogs.containsAll(actualAllDogs));
		assertEquals(allDogs.size(), actualAllDogs.size(), 0);

	}

	@Test
	public void getShouldReturnCorrectDog() {
		Dog dog = createTestDog();
		when(dogDAO.get(dog.getId())).thenReturn(dog);
		assertReflectionEquals(dog, dogService.get(dog));
		verify(dogDAO, times(1)).get(dog.getId());
	}

	private Dog createTestDog() {
		Dog dog = new Dog();
		dog.setAge(10);
		dog.setBreed("pinguin");
		dog.setHistory("Some history");
		dog.setId(1234);
		dog.setName("Charly");
		dog.setSex(false);
		return dog;
	}

	private List<Dog> createTestDogsList() {
		List<Dog> dogs = new ArrayList<Dog>(10);
		for (int i = 0; i < 10; i++) {
			Dog dog = createTestDog();
			dog.setId(i);
			dogs.add(dog);
		}
		return dogs;
	}

}
