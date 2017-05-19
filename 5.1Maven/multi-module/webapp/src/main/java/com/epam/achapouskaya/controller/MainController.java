package com.epam.achapouskaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		System.out.print("Show home page");
		return "homepage";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.print("Login page");
		return "homepage";
	}
}
