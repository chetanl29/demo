package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 13;
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, studentId);
			theStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			System.out.println("Update Done....");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='scooby@outlook.com' where email='gooby@outlook.com'").executeUpdate();
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
