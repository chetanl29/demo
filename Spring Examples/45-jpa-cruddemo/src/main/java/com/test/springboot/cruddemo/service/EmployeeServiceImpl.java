package com.test.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.springboot.cruddemo.dao.EmployeeDAO;
import com.test.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDao;
	
	/*
	 * Description:
	 * 
	 * Parameter 0 of constructor in
	 * com.test.springboot.cruddemo.service.EmployeeServiceImpl required a single
	 * bean, but 2 were found: - employeeDAOHibernateImpl: defined in file
	 * [F:\Workspace\Spring Practice Examples
	 * 2\45-jpa-cruddemo\target\classes\com\test\springboot\cruddemo\dao\
	 * EmployeeDAOHibernateImpl.class] - employeeDAOJpaImpl: defined in file
	 * [F:\Workspace\Spring Practice Examples
	 * 2\45-jpa-cruddemo\target\classes\com\test\springboot\cruddemo\dao\
	 * EmployeeDAOJpaImpl.class]
	 * 
	 * 
	 * Action:
	 * 
	 * Consider marking one of the beans as @Primary, updating the consumer to
	 * accept multiple beans, or using @Qualifier to identify the bean that should
	 * be consumed
	 */
	
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);

	}

}
