package com.manny.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Swin 1000 meters as a daily warm-up";
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getForTune();
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getTeam() {
		return this.team;
	}

}
