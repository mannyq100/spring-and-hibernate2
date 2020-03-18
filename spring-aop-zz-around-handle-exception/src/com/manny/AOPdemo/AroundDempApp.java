package com.manny.AOPdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manny.AOPdemo.service.TrafficFortuneService;

public class AroundDempApp {

	public static void main(String[] args) {
		
		Logger myLogger =
				Logger.getLogger(AroundDempApp.class.getName());
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// call bean from spring controller
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		myLogger.info("\n Calling getFortune ");

		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is:"+data);
		myLogger.info("Finished");
		
		
		// close the context
		context.close();
	}

}
