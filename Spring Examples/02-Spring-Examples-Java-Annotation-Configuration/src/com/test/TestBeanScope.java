package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.CustomSportConfig;

public class TestBeanScope {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(CustomSportConfig.class);
		Coach theCoach = context.getBean("getSwimCoach",Coach.class);
		theCoach.getDailyFortunes();
		
		context.close();

	}

}
