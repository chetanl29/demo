package com.test.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.Customer;
import com.test.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Map<String,Object> map) {
		map.put("customer", new Customer());
		return "NewCustomer";
	}
	
	@RequestMapping("/add")
	public String addCustomer(@Valid Customer customer,Errors errors) {
		if(errors.hasErrors()) {
			return "NewCustomer";
		}
		int iResult = customerService.addCustomer(customer);
		customer.setCustomerId(iResult);
		return "success";
	}
	
	@RequestMapping("/get")
	public String getAllCustomers(Model model) {
		List<Customer> lCustomer = customerService.getAllCustomers();
		System.out.println("Customer List ::= "+lCustomer);
		model.addAttribute("lCustomer",lCustomer);
		return "display";
		
	}

}
