package com.manny.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneSevice;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
		
	}
	
	// define my innit
//	@PostConstruct
//	 public void doMyStartUpStuff() {
//		 System.out.println(" >>TennisCoach: Inside of doMyStartUpStuff()");
//	 }
//	@PreDestroy
//	//define my destroy
//	 public void doMyCleanUpStuff() {
//		 System.out.println(">>TennisCoach: Inside of doMyCleanUpStuff()");
//	 }
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneSevice) {
		this.fortuneSevice = fortuneSevice;
	}
	*/


	// define setter method
	/*
	@Autowired
	public void setFortuneSevice(FortuneService fortuneSevice) {
		this.fortuneSevice = fortuneSevice;
	}
	*/



	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneSevice.getForTune();	}

}
