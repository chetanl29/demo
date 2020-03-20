package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("theSwimCoach")
public class SwimCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService service;

	@Override
	public void getDailyWorkOut() {
		System.out.println("Practice Swimming........");
	}

	@Override
	public void getDailyFortunes() {
		System.out.println("Daily Fortunes::= "+service.getDailyFortunes());
	}

}
