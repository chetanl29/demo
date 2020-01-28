package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.Customer;
import com.test.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("customer", new Customer());
		return "registration";
	}
	
	@PostMapping("/save")
	public String save(Customer customer, Model model) {
		service.save(customer);
		model.addAttribute("Customer", "Customer created successfully.");
		return "success";
	}

}
