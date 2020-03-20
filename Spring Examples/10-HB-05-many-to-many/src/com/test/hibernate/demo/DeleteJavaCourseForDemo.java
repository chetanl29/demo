package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Course;
import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;
import com.test.hibernate.demo.entity.Review;
import com.test.hibernate.demo.entity.Student;

public class DeleteJavaCourseForDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {		
			session.beginTransaction();
			
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("Deleting Course........"+tempCourse);
			session.delete(tempCourse);
			System.out.println("Course Deleted........");
			
			System.out.println("");
			session.getTransaction().commit();
			System.out.println("Object Deleted....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
