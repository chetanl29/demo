package com.test;

public class TestClient {

	public static void main(String[] args) {

		CalServiceService service = new CalServiceService();
		CalService calServ = service.getCalServicePort();
		int add = calServ.add(10, 20);
		System.out.println("Add ::= "+add);
		
		int sub = calServ.sub(10, 20);
		System.out.println("Sub ::= "+sub);

	}

}
