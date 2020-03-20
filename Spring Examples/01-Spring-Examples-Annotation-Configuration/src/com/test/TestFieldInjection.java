package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFieldInjection {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("spring-annotation-config.xml");

		Coach theCoach = context.getBean("theSwimCoach",Coach.class);
		theCoach.getDailyWorkOut();
		theCoach.getDailyFortunes();
		context.close();
	}

}
