package com.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	private FortuneService service;
	
	@Autowired
	@Qualifier("randomFortuneService")
	public void setService(FortuneService service) {
		this.service = service;
	}
	
	@PostConstruct
	public void init() {
		System.out.println(">> Cricket Coach Do my StartUp stuff");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println(">> Cricket Coach Do my Destroy stuff");
	}

	@Override
	public void getDailyWorkOut() {
		System.out.println("Practicing Cricket.......");
	}

	@Override
	public void getDailyFortunes() {
		System.out.println("Daily Fortunes ::= "+service.getDailyFortunes());
	}

}
