package com.test.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	//@Autowired
	//No need to use @Autowired annotation if single field exists and a parametrized constructor exists. it's a spring enhancement
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	//@Transactional
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = session.createQuery(" from Employee", Employee.class);
		List<Employee> employee = theQuery.getResultList();
		//System.out.println("employee ::= "+employee);
		return employee;
	}

	@Override
	public Employee findById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, theId);
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
