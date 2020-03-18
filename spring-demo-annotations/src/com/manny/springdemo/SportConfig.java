package com.manny.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration @ComponentScan("com.manny.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for our sad fornune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	// define bean for our swim coach and inject dependancy
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
