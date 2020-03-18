package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Instructor;
import com.manny.hibernate.demo.entity.InstructorDetail;
import com.manny.hibernate.demo.entity.Student;

public class DeleteDemo {

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
						
			
			//start a transaction
			session.beginTransaction();
		
			// get instructor by id
			int theId= 2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found "+tempInstructor);
			
			//delete the instructor
			if(tempInstructor != null) {
				System.out.println("Deleting instructor "+tempInstructor);
				session.delete(tempInstructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			
		}
		finally {
			factory.close();
		}
		
	}

}
