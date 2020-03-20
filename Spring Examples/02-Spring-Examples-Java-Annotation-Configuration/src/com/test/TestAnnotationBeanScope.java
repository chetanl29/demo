package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.SportConfig;

public class TestAnnotationBeanScope {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(SportConfig.class);
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		System.out.println("Memory for theCoach "+theCoach);
		
		System.out.println("Memory for alphaCoach "+alphaCoach);
		context.close();
	}

}
