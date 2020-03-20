package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationBeanScope {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context
					= new ClassPathXmlApplicationContext("spring-annotation-config.xml");
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		System.out.println("Memory for theCoach "+theCoach);
		
		System.out.println("Memory for alphaCoach "+alphaCoach);
		context.close();
	}

}
