package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestContoller {

	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public String test() {
		return "Hello World";
	}
}
