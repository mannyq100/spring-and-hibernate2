package com.manny.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Course;
import com.manny.hibernate.demo.entity.Instructor;
import com.manny.hibernate.demo.entity.InstructorDetail;
import com.manny.hibernate.demo.entity.Review;
import com.manny.hibernate.demo.entity.Student;

public class AddCoursesForJamesDemo {

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
			
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\n Loaded student: "+ tempStudent);
			System.out.println("Courses: "+tempStudent.getCourses());
			
			
			Course tempCourse1 = new Course("SQL Programming- Learn sql");
			Course tempCourse2 = new Course("Rest APIs- Learn to build restful APIs");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			System.out.println("\nSaving the courses...");
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
