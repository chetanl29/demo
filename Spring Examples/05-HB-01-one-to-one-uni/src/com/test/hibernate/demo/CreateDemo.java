package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;
import com.test.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "Music");
			Instructor tempInstructor = new Instructor("Madhu", "K", "madhu@gmail.com");
			tempInstructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			session.save(tempInstructor);
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
