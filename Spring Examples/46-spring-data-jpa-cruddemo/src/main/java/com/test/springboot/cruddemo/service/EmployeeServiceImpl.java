package com.test.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.springboot.cruddemo.dao.EmployeeRepository;
import com.test.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository repository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	/*Removed @Transactional as JpaRepository provides this functionality*/
	//@Transactional
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	//@Transactional
	public Employee findById(int theId) {
		Optional<Employee> result = repository.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find employee Id - "+theId);
		}
		return theEmployee;
	}

	@Override
	//@Transactional
	public void save(Employee theEmployee) {
		repository.save(theEmployee);
	}

	@Override
	//@Transactional
	public void deleteById(int theId) {
		repository.deleteById(theId);
	}

}
