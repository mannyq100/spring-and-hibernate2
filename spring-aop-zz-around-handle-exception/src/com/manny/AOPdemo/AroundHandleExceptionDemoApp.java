package com.manny.AOPdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manny.AOPdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		Logger myLogger =
				Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// call bean from spring controller
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		myLogger.info("\n Calling getFortune ");
		
		boolean tripWire =true;
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is:"+data);
		myLogger.info("Finished");
		
		
		// close the context
		context.close();
	}

}
