package com.test.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.springboot.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	List<Employee> theEmployee;
	
	@PostConstruct
	private void loadData() {
		theEmployee = new ArrayList<Employee>();
		
		Employee emp1 = new Employee(1, "Chetan", "L", "chetan011993@gmail.com");
		Employee emp2 = new Employee(2, "Naveen", "K", "naveen@gmail.com");
		Employee emp3 = new Employee(3, "Mohan", "P", "mohan@gmail.com");
		
		theEmployee.add(emp1);
		theEmployee.add(emp2);
		theEmployee.add(emp3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployee);
		return "list-employees";
	}

}
