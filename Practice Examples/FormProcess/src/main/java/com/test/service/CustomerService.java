package com.test.service;

import java.util.List;

import com.test.model.Customer;

public interface CustomerService {

	int addCustomer(Customer customer);
	List<Customer> getAllCustomers();

}