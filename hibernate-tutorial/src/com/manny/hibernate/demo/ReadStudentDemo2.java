package com.manny.hibernate.demo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manny.hibernate.demo.entity.Student;

public class ReadStudentDemo2 {

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
			Student tempStudent = new Student("David","Goglins","paul@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving student to mysql");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//retrieve student from database
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student aStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Printing out the student \n"+ aStudent.toString());
			
			List<Student> studentList = session.createQuery("from Student ").getResultList();
			
			displayStudents(studentList);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			
		}
		finally {
			factory.close();
		}
		
		//
	}

	private static void displayStudents(List<Student> studentList) {
		for(Student theStudents : studentList) {
			System.out.println(theStudents);
		}
	}

}
