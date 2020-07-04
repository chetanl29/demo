package com.test.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is "+LocalDateTime.now();
	}
	
	//expose a new endpoint for "workout" after dev-tools are added
	@GetMapping("/workout")
	public String getDailyWorkOut() {
		return "Run a Hard 5K";
	}
	
	//expose a new endpoint for "fortune" after dev-tools are added
	@GetMapping("/fortune")
	public String getDailyFotune() {
		return "Today is your lucky day.";
	}

}
