package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Course;
import com.manny.hibernate.demo.entity.Instructor;
import com.manny.hibernate.demo.entity.InstructorDetail;
import com.manny.hibernate.demo.entity.Review;
import com.manny.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//create a course
			Course tempCourse = new Course("A c-sharp Course");
			
			//  saving the course
			System.out.println("\n saving the course..");
			session.save(tempCourse);
			System.out.println("Saved the course :"+tempCourse);
			
			//create a student
			 Student tempStudent1 = new Student("John", "Doe", "jondoe@gmail.com");
			 Student tempStudent2 = new Student("James", "Blake", "jblake@gmail.com");

			 
			 //add student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the students
			System.out.println("\nSaving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved Students  :"+tempCourse.getAstudent());


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
