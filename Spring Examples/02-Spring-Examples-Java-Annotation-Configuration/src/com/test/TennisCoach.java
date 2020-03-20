package com.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	private FortuneService service;
	
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService service) {
		System.out.println(">>TennisCoach Argument constructor");
		this.service = service;
	}

	@Override
	public void getDailyWorkOut() {
		System.out.println("Practice Tennis.......");
	}
	
	public void getDailyFortunes() {
		System.out.println("Daily Fortunes ::= "+service.getDailyFortunes());
	}
	
	@PostConstruct
	public void init() {
		System.out.println(">> Tennis Coach Do my StartUp stuff");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println(">> Tennis Coach Do my Destroy stuff");
	}

}
