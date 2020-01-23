package com.test.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.test.springboot.cruddemo.entity.Employee;

@Repository
//@Primary
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
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query theQuery = entityManager.createQuery(" from Employee");
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
