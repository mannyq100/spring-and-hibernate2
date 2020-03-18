package com.manny.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getForTune() {
		return "Today is your lucky day";
	}
	
		
	

}
