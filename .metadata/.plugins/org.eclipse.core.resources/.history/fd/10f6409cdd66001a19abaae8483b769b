package com.manny.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

	public static void main(String[] args) {
		// Load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext2.xml");
		
		// retrieve bean from the spring containter
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// Check to see if they are same
		boolean result = (theCoach == alphaCoach);
		
		//print the results
		
		System.out.println("\nPointing to the same object: "+ result);

		System.out.println("\nMemory location for theCoach: "+ theCoach);
		System.out.println("\nMemory location for theCoach: "+ alphaCoach);
		
		// close the context
		context.close();

		

	}

}
