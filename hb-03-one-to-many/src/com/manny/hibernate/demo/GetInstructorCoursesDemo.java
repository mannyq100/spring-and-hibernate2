package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Student;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// get instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//create some courses
			Course tempCourse1 = new Course("Java-Course");
			Course tempCourse2 = new Course("Python-Course");

			//add courses to the instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
