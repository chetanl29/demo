package com.test.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
		
			System.out.println("Student who have Last Name as L");
			theStudents = session.createQuery("from Student s where s.lastName='L'").list();
			
			displayStudents(theStudents);
			
			System.out.println("User with Last Name 'L' or First Name 'Naveen'");
			theStudents = session.createQuery("from Student s where s.lastName = 'L' or s.firstName = 'Naveen'").getResultList();
			displayStudents(theStudents);
			
			System.out.println("Student whose mail id end with 'gmail.com'");
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			displayStudents(theStudents);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}
