package com.test;

public interface FortuneService {
	
	final String[] fortunes = {"Smile in the mirror. Do that every morning and you'll start to see a big difference in your life." 
			,"Some people dream of success, while other people get up every morning and make it happen.",
			"Opportunities are like sunrises. If you wait too long, you miss them.",
			"When I wake up every morning, I thank God for the new day."
	};
	
	public String getDailyFortunes();

}
