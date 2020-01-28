package com.test;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://test.com/", portName = "CalServicePort", serviceName = "CalServiceService")
public class CalService {
	
	@WebMethod(operationName = "add", action = "urn:Add")
	public int add(int i , int j) {
		return i + j;
	}
	
	@WebMethod(operationName = "sub", action = "urn:Sub")
	public int sub(int i , int j) {
		return i - j;
	}

}
