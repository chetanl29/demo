package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Instructor;
import com.test.hibernate.demo.entity.InstructorDetail;
import com.test.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int instructorDetailId = 7;
		
		try {
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
			System.out.println("Instructor Detail = "+instructorDetail);
			
			System.out.println("The associated instructor ::= "+instructorDetail.getInstructor());
			
			if(instructorDetail != null) {
				System.out.println("Deleting InstructionDetail ::= "+instructorDetail);
				//remove the associated object reference
				//break bi-directional link
				instructorDetail.getInstructor().setInstructorDetail(null);
				session.delete(instructorDetail);
			}
			
			session.getTransaction().commit();
			System.out.println("Object Deleted....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//handle connection leak issue
			session.close();
			factory.close();
		}
	}
}
