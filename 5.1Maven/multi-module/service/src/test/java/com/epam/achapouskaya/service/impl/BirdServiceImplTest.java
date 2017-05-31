package com.epam.achapouskaya.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import static org.mockito.Mockito.when;
import static org.unitils.reflectionassert.ReflectionAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.epam.achapouskaya.dao.BirdDAO;
import com.epam.achapouskaya.model.Bird;

@RunWith(MockitoJUnitRunner.class)
public class BirdServiceImplTest {
	
	BirdServiceImpl birdService;

	@Mock
	BirdDAO birdDAO;

	@Before
	public void setUp() {
		System.out.println("Before Test");
		birdService = new BirdServiceImpl();
		birdService.setBirdDAO(birdDAO);
	}
	
	@After
    public void tearDown() {
		System.out.println("After Test");
        birdDAO = null;
        birdService = null;
    }

	@Test
	public void createBirdWithNullShouldReturnNull() {
		assertNull(birdService.create(null));
		verifyZeroInteractions(birdDAO);
	}
	
	
	@Test
	public void createBirdWithBirdShouldReturnTheSameBird() {
		Bird bird = createTestBird();
		when(birdDAO.create(bird)).thenReturn(bird.getId());
		assertEquals(bird, birdService.create(bird));
		verify(birdDAO, times(1)).create(bird);
	}
	
	@Test 
	public void updateBirdWithNullShouldReturnNull() {
		assertNull(birdService.update(null));
		verifyZeroInteractions(birdDAO);
	}
	
	@Test
	public void updateBirdShouldReturnUpdatedBird() {
		Bird oldBird = createTestBird();
		Bird updatedBird = createTestBird();
		updatedBird.setName("Updated name");
		when(birdDAO.update(oldBird)).thenReturn(updatedBird);
		assertReflectionEquals(updatedBird, birdService.update(oldBird));
		verify(birdDAO, times(1)).update(oldBird);
	}
	
	@Test
	public void updateBirdShouldntChangeBirdId() {
		Long id = (long) 777;
		Bird oldBird = createTestBird();
		oldBird.setId(id);
		Bird updatedBird = createTestBird();
		updatedBird.setId(id);
		updatedBird.setName("Updated name");
		when(birdDAO.update(oldBird)).thenReturn(updatedBird);
		assertEquals(id, birdService.update(oldBird).getId(), 0);
	}
	
	@Test
	public void deleteNullShouldntDeleteAnything() {
		assertFalse(birdService.delete(null));
		verifyZeroInteractions(birdDAO);
	}
	
	@Test
	public void deleteShouldDeleteOnlyDeletedItem() {
		Bird bird = createTestBird();
		when(birdDAO.delete(bird.getId())).thenReturn(true);
		assertTrue(birdService.delete(bird));
		verify(birdDAO, times(1)).delete(bird.getId());
		verifyNoMoreInteractions(birdDAO);
	}
	
	
	@Test
	public void getAllShouldReturnAllElementsFromDAO() {
		List<Bird> allBirds = createTestBirdsList();
		when(birdDAO.getAll()).thenReturn(allBirds);
		List<Bird> actualAllBirds = birdService.getAll();
		assertTrue(actualAllBirds.containsAll(allBirds) && allBirds.containsAll(actualAllBirds));
		assertEquals(allBirds.size(), actualAllBirds.size(), 0);
		
 	}

	@Test
	public void getShouldReturnCorrectBird() {
		Bird bird = createTestBird();
		when(birdDAO.get(bird.getId())).thenReturn(bird);
		assertReflectionEquals(bird, birdService.get(bird));
		verify(birdDAO, times(1)).get(bird.getId());
	}
	
	private Bird createTestBird() {
		Bird bird = new Bird();
		bird.setAge(10);
		bird.setBreed("pinguin");
		bird.setHistory("Some history");
		bird.setId(1234);
		bird.setName("Charly");
		bird.setSex(false);
		bird.setSinging(true);
		return bird;
	}
	
	private List<Bird> createTestBirdsList() {
		List<Bird> birds = new ArrayList<Bird>(10);
		for (int i = 0; i < 10; i++) {
			Bird bird = createTestBird();
			bird.setId(i);
			birds.add(bird);
		}
		return birds;
	}

}
