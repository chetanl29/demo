package com.test.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING STUFF: ADDING AN MEMBERSHIP ACCOUNT");
		return false;
	}

	public boolean goToSleep() {
		System.out.println(getClass() + " I'm going to sleep now.....");
		return true;
	}

	
}
