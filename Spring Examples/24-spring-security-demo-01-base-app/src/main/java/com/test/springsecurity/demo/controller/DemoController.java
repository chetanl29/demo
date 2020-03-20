package com.test.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	//Note:-
	//This Project is developed with Java Spring MVC using pure Java config.
	//No Spring security has been added.
	//This is just a base project for Spring MVC.
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
}


