package com.test.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Chetan", "L", "chetan011993@gmail.com");
			Student student1 = new Student("Mohan Babu", "P", "mohan@gmail.com");
			Student student2 = new Student("Meghnath", "R", "meghnath@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.save(student1);
			session.save(student2);
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
