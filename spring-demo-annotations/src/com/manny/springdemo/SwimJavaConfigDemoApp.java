package com.manny.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
	
	public static void main(String[] args) {
		
		//read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		System.out.println("Email: "+ theCoach.getEmail());
		System.out.println("Team: "+ theCoach.getTeam());
		
		//close the context
		context.close();
	}
}
