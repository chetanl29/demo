package com.test.exception;

public class MovieNotFoundException extends RuntimeException {
	
	public MovieNotFoundException(String sMsg) {
		super(sMsg);
	}

}
