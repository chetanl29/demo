package com.test.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> myAccounts = null;
		
		try{
			boolean tripWire = true;
			myAccounts = theAccountDAO.findAccounts(tripWire);
		}catch(Exception e) {
			System.out.println("Main program....caught exception "+e);
		}
		
		System.out.println("After Throwing DemoApp===========");
		
		System.out.println("Accounts ::= "+myAccounts);
		
		System.out.println("After Throwing DemoApp===========");
		
		context.close();
	}

}
