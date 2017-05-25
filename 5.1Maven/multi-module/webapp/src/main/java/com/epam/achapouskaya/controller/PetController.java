package com.epam.achapouskaya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.achapouskaya.model.Bird;
import com.epam.achapouskaya.model.Cat;
import com.epam.achapouskaya.model.Dog;
import com.epam.achapouskaya.model.WoolLength;
import com.epam.achapouskaya.service.BirdService;
import com.epam.achapouskaya.service.CatService;
import com.epam.achapouskaya.service.DogService;

@Controller
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private DogService dogService;
	
	@Autowired
	private BirdService birdService;

	@Autowired
	private CatService catService;

	public DogService getDogService() {
		return dogService;
	}

	public void setDogService(DogService dogService) {
		this.dogService = dogService;
	}
	
	//Are we really need getters here?
	public BirdService getBirdService() {
		return birdService;
	}

	public void setBirdService(BirdService birdService) {
		this.birdService = birdService;
	}
	
	

	public CatService getCatService() {
		return catService;
	}

	public void setCatService(CatService catService) {
		this.catService = catService;
	}

	@RequestMapping(path = "/dogs", method = RequestMethod.GET)
	public String showAllDogs(ModelMap model) {
		System.out.print("Show all dogs page");
		model.addAttribute("dogs", this.dogService.getAll());
		return "dogs";
	}

	@RequestMapping(value = "/dogs/add", method = RequestMethod.GET)
	public ModelAndView addDog() {
		return new ModelAndView("addDog", "command", new Dog());
	}
	
	@RequestMapping(path = "/dogs/add", method = RequestMethod.POST)
	public String saveDog(@ModelAttribute("dog") @Valid Dog dog, BindingResult result, ModelMap model) {
		System.out.print("Add dog page");
		System.out.print(this.dogService.create(dog));
		model.addAttribute("dogs", this.dogService.getAll());
		return "dogs";
	}
	
	@RequestMapping(path = "/birds", method = RequestMethod.GET)
	public String showAllBirds(ModelMap model) {
		System.out.print("Show all birds page");
		model.addAttribute("birds", this.birdService.getAll());
		return "birds";
	}

	@RequestMapping(value = "/birds/add", method = RequestMethod.GET)
	public ModelAndView addBird() {
		return new ModelAndView("addBird", "command", new Bird());
	}
	
	@RequestMapping(path = "/birds/add", method = RequestMethod.POST)
	public String saveBird(@ModelAttribute("bird") Bird bird, ModelMap model) {
		System.out.print("Add bird page");
		System.out.print(this.birdService.create(bird));
		model.addAttribute("birds", this.birdService.getAll());
		return "birds";
	}
	
	//CATS
	@RequestMapping(path = "/cats", method = RequestMethod.GET)
	public String showAllCats(ModelMap model) {
		System.out.print("Show all cats page");
		model.addAttribute("cats", this.catService.getAll());
		return "cats";
	}

	@RequestMapping(value = "/cats/add", method = RequestMethod.GET)
	public ModelAndView addCat() {
		ModelAndView model = new ModelAndView("addCat", "command", new Cat());
		model.addObject("woolLengthTypes", WoolLength.values());
		return model;
	}
	
	@RequestMapping(path = "/cats/add", method = RequestMethod.POST)
	public String saveCat(@ModelAttribute("cat") Cat cat, ModelMap model) {
		System.out.print("Add cat page");
		System.out.print(this.catService.create(cat));
		model.addAttribute("cats", this.catService.getAll());
		return "cats";
	}
	

	
}
