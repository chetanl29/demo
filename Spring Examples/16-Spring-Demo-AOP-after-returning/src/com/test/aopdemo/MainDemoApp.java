package com.test.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.aopdemo.dao.AccountDAO;
import com.test.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO",MembershipDAO.class);
		
		Account theAccount = new Account();
		theAccount.setName("Chetan");
		theAccount.setLevel("GOLD");
		
		theAccountDAO.addAccount(theAccount,true);
		theAccountDAO.doWork();
		
		System.out.println("==============================================");
		//call setter and getter method
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		System.out.println("==============================================");
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		context.close();
	}

}
