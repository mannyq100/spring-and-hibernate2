package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Instructor;
import com.manny.hibernate.demo.entity.InstructorDetail;
import com.manny.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
						
			//create the instructor object
			System.out.println("creating new Instructor object");
			Instructor tempInstructor = new Instructor("Manny", "Quist","mannyq@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/watch?v=yRwQ7A6jVLk", "Teaching math");
			
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			// save the instructor object
			System.out.println("saving student to mysql");
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			
		}
		finally {
			factory.close();
		}
		
	}

}
