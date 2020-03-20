package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.SportConfig;

public class TestSetterInjection {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach theCoach = context.getBean("cricketCoach",Coach.class);
		theCoach.getDailyWorkOut();
		theCoach.getDailyFortunes();
		
		context.close();
	}

}
