package com.test.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger =
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService service =
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Main Program :: AroundDemoApp");
		
		myLogger.info("Calling getFortune()");
		
		String data = service.getFortune();
		
		myLogger.info("My fortune is:= "+data);
		
		myLogger.info("Finished.....");
		
		context.close();
	}

}
