package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.CarromCoach;
import com.test.Coach;
import com.test.FortuneService;
import com.test.RandomFortuneService;

@Configuration
public class CustomSportConfig {

	@Bean
	public Coach getSwimCoach() {
		return new CarromCoach(getFortuneService());
	}
	
	@Bean
	public FortuneService getFortuneService() {
		return new RandomFortuneService();
	}
}
