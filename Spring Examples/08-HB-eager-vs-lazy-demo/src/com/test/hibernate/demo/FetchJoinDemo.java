package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Course;
import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {  //Option 1: call getter method while session is open

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {		
			int instructorId = 1;
			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			
			System.out.println("Instructor Name::= "+tempInstructor);
			
			System.out.println("Courses::= "+tempInstructor.getCourses());
			
			session.getTransaction().commit();
			session.close();
			
			//Option 1: call getter method while session is open
			System.out.println("Courses::= "+tempInstructor.getCourses());
			
			System.out.println("Object Fetched....");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			factory.close();
		}
	}
}
