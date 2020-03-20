package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Course;
import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "Playing");
			Instructor tempInstructor = new Instructor("Scooby", "Doo", "scooby@gmail.com");
			tempInstructor.setInstructorDetail(instructorDetail);			
			session.beginTransaction();
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Object Saved....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
