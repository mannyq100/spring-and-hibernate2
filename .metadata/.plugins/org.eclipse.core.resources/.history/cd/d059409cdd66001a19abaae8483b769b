package com.manny.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: "+ fortuneService.getFortune() ;
	}
	
	// add an init method
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: inside doMyStartUpStuff method");
	}
	
	// add a destroy method
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: Inside doMyCleanUpStuff method");
		
		
		
	}

}
