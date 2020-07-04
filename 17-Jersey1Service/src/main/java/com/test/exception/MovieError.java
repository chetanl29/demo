package com.test.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieError {
	
	private int status;
	
	private String message;
	
	public MovieError() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieError(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
