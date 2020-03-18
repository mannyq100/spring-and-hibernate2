package com.manny.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp2 {

	public static void main(String[] args) {
		// Load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext3.xml");
		
		// retrieve bean from the spring containter
		Coach theCoach = context.getBean("myCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkOut());	
		
		// close the context
		context.close();

		

	}

}
