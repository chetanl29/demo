package com.test.model;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = 8102916184504152832L;

	private String sCustomerName;
	
	private int customerAge;
	
	public Customer() {
	}

	public String getsCustomerName() {
		return sCustomerName;
	}

	public void setsCustomerName(String sCustomerName) {
		this.sCustomerName = sCustomerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	
}
