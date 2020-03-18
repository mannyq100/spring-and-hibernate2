package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
						
			//create the student object
			System.out.println("creating new student object");
			Student tempStudent = new Student("Paul","Walker","paul@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving student to mysql");
			session.save(tempStudent);
			
			
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
