package com.test.dao;

import java.util.List;

import com.test.model.Customer;

public interface CustomerDao {

	int addCustomer(Customer customer);
	List<Customer> getAllCustomers();

}