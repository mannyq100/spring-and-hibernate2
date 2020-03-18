package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Course;
import com.manny.hibernate.demo.entity.Instructor;
import com.manny.hibernate.demo.entity.InstructorDetail;
import com.manny.hibernate.demo.entity.Review;
import com.manny.hibernate.demo.entity.Student;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId = 10;
			
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println(tempCourse.getReview());
			
			System.out.println("Now deleting the course");
			
			session.delete(tempCourse);
			
	
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
