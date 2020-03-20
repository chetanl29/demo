package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Course;
import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;
import com.test.hibernate.demo.entity.Review;

public class GetCoursesAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int courseId = 10;
			session.beginTransaction();
			
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("Course Details ::= "+tempCourse);
			
			System.out.println("Reviews ::= "+tempCourse.getReviews());
			
			session.getTransaction().commit();
			System.out.println("Object Fetched....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
