package com.test.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
