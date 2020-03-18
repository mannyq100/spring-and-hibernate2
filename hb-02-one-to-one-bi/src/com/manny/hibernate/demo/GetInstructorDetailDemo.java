package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
		
			// get the instructor detail object
			int theId =3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("the associted instructor: "+tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("the associted instructor: "+tempInstructorDetail.getInstructor());

			//commit the transaction
			session.getTransaction().commit();
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close(); 
			factory.close();
		}
		
	}

}
