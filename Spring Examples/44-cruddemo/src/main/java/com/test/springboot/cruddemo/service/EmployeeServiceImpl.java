package com.test.springboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.springboot.cruddemo.dao.EmployeeDAO;
import com.test.springboot.cruddemo.entity.Employee;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDao;
	
	public EmployeeServiceImpl(EmployeeDAO employeeDao) {
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
