package com.test.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " DOING WORK");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + " in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(){
		
		List<Account> myAccounts = new ArrayList<Account>();
		myAccounts.add(new Account("Chetan", "Gold"));
		myAccounts.add(new Account("Naveen", "Platinum"));
		myAccounts.add(new Account("Mohan", "Silver"));
		myAccounts.add(new Account("Meghnath", "Iron"));
		
		return myAccounts;
	}

}
