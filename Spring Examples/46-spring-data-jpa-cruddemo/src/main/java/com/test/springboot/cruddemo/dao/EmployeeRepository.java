package com.test.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
