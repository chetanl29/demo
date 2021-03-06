package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Course;
import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			Course tempCourse1= new Course("JAVA");
			Course tempCourse2= new Course("Spring");
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
