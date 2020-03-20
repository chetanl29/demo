package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;
import com.test.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int instructorId = 2;
		
		try {
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			System.out.println("Found Instructor ::= "+tempInstructor);
			if (tempInstructor != null) {
				System.out.println("Deleting "+tempInstructor);
				session.delete(tempInstructor);
				
			}
			session.getTransaction().commit();
			System.out.println("Object Deleted....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
