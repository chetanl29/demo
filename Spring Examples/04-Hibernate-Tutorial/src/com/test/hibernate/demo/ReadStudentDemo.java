package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Naveen", "K", "naveen@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			System.out.println("Saved Student Generated id::= "+student.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id:= "+student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Student Data ::= "+myStudent);
			
			session.getTransaction().commit();
			
			
			System.out.println("Object Saved....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
