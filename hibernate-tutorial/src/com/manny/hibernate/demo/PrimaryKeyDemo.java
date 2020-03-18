package com.manny.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
						
			//create 3 student object
			System.out.println("creating new student object");
			Student tempStudent1 = new Student("James","Jons","james@gmail.com");
			Student tempStudent2 = new Student("tim","Cook","tim@gmail.com");
			Student tempStudent3 = new Student("Jack","Ryan","jack@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving student to mysql");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			
		}
		finally {
			factory.close();
		}
		
		//
	}
}
