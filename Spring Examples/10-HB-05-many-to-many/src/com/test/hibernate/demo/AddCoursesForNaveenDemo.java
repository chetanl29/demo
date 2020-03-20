package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Course;
import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;
import com.test.hibernate.demo.entity.Review;
import com.test.hibernate.demo.entity.Student;

public class AddCoursesForNaveenDemo {

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
			
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoaded student ::= "+tempStudent);
			
			System.out.println("Courses ::= "+tempStudent.getCourses());
			
			Course tempCourse1 = new Course("C");
			Course tempCourse2 = new Course("Rubix Cube");
			Course tempCourse3 = new Course("Yoga");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);
			
			System.out.println("Saving the Courses......");
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			System.out.println("Courses has been saved......");
			
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
