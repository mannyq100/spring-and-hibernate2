package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Course;
import com.manny.hibernate.demo.entity.Instructor;
import com.manny.hibernate.demo.entity.InstructorDetail;
import com.manny.hibernate.demo.entity.Review;
import com.manny.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

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
			
			//create a course
			Course tempCourse = new Course("A c-sharp Course");
			
			//add some reviews
			tempCourse.addReview(new Review("This is a good course!"));
			tempCourse.addReview(new Review("Very well explained"));
			tempCourse.addReview(new Review("This is a short course"));


			//save the course  and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReview());
			
			session.save(tempCourse);
			
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
