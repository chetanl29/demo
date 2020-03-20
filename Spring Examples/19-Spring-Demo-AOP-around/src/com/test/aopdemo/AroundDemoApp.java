package com.test.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService service =
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Main Program :: AroundDemoApp");
		
		System.out.println("Calling getFortune()");
		
		String data = service.getFortune();
		
		System.out.println("My fortune is:= "+data);
		
		System.out.println("Finished.....");
		
		context.close();
	}

}
