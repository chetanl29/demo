package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.CustomerDao;
import com.test.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	
	/* (non-Javadoc)
	 * @see com.test.service.CustomerService#save(com.test.model.Customer)
	 */
	@Override
	public void save(Customer customer) {
		dao.save(customer);
	}
}
