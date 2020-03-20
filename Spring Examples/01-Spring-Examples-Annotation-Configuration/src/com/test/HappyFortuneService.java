package com.test;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getDailyFortunes() {
		return fortunes[0];
	}

}
