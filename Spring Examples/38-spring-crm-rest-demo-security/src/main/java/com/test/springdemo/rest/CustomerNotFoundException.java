package com.test.springdemo.rest;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
	
	public CustomerNotFoundException(String message, Throwable cause,boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
