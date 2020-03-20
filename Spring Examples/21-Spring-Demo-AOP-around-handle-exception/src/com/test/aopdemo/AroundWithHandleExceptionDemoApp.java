package com.test.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.aopdemo.service.TrafficFortuneService;

public class AroundWithHandleExceptionDemoApp {
	
	private static Logger myLogger =
			Logger.getLogger(AroundWithHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService service =
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Main Program :: AroundDemoApp");
		
		myLogger.info("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = service.getFortune(tripWire);
		
		myLogger.info("My fortune is:= "+data);
		
		myLogger.info("Finished.....");
		
		context.close();
	}

}
