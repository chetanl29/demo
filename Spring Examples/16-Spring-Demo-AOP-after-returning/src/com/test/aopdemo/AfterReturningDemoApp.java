package com.test.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> myAccounts = theAccountDAO.findAccounts();
		
		System.out.println("After ReturningDemoApp===========");
		
		System.out.println("Accounts ::= "+myAccounts);
		
		System.out.println("After ReturningDemoApp===========");
		
		context.close();
	}

}
