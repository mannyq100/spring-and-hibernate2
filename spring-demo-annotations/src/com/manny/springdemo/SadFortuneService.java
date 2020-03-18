package com.manny.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getForTune() {
		return "Today is a sad day";
	}

}
