package com.manny.springdemo;

public class BaseballCoach implements Coach {
	
	// define private field for the dependency
	private FortuneService fortuneService;
	
	// define constructor for dependency injection
	public BaseballCoach(FortuneService fortuneservice) {
		this.fortuneService = fortuneservice;
	}

	@Override
	public String getDailyWorkOut() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}

}
