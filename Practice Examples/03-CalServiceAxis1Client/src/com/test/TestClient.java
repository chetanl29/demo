package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.client.Service;

public class TestClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException {
		 URL url = new URL("http://localhost:8567/03-CalServiceAxis1/services/CalService");
		 Service service = new Service();
		 
		 CalServiceSoapBindingStub stub = new CalServiceSoapBindingStub(url, service);
		 int sum = stub.add(10, 20);
		 System.out.println("Sum ::= "+sum);
		 
		 int substraction = stub.sub(10, 20);
		 System.out.println("Difference ::= "+substraction);
	}

}
