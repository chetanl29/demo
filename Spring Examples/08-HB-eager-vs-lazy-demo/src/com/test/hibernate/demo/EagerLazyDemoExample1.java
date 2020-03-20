package com.test.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.test.hibernate.demo.entity.Course;
import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemoExample1 {  //Option 2: Query with HQL

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {		
			int theInstructorId = 1;
			session.beginTransaction();
			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId",Instructor.class);
			query.setParameter("theInstructorId", theInstructorId);
			
			Instructor tempInstructor  = query.getSingleResult();
			
			System.out.println("Instructor Name::= "+tempInstructor);
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("Session is Closed.....");
			
			//Option 2: Hibernate Query with QL
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
