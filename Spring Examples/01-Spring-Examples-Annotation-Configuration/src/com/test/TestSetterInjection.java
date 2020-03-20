package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetterInjection {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("spring-annotation-config.xml");
		
		Coach theCoach = context.getBean("cricketCoach",Coach.class);
		theCoach.getDailyWorkOut();
		theCoach.getDailyFortunes();
		
		context.close();
	}

}
