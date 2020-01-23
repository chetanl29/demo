package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired(required=true)
	private HibernateTemplate hibernateTemplate;
	
	/* (non-Javadoc)
	 * @see com.test.dao.CustomerDao#addCustomer(com.test.model.Customer)
	 */
	@Override
	@Transactional(readOnly = false)
	public int addCustomer(Customer customer) {
		int iResult = (Integer)hibernateTemplate.save(customer);
		return iResult;
	}
	
	@Override
	@Transactional(readOnly = false)
	public List<Customer> getAllCustomers() {
		List<Customer> lCustomer = (List<Customer>) hibernateTemplate.loadAll(Customer.class);
		return lCustomer;
	}
}
