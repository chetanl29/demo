package com.test;

public class CarromCoach implements Coach {
	
	private FortuneService service;
	
	public CarromCoach(FortuneService service) {
		this.service = service;
	}

	@Override
	public void getDailyWorkOut() {
		System.out.println("Practicing Carrom......");

	}

	@Override
	public void getDailyFortunes() {
		System.out.println("Carrom Fortune ::= "+service.getDailyFortunes());

	}

}
