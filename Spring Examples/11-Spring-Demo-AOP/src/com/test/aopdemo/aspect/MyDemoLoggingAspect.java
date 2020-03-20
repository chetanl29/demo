package com.test.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(public void com.test.aopdemo.dao.AccountDAO.addAccount())")  //Matches method with addAccount() present in com.test.aopdemo.dao.AccountDAO class
	//@Before("execution(public void addAccount())")  //Matches method with addAccount() present in any class
	//@Before("execution(public void add*())") //Using Wildcard pattern to match
	//@Before("execution( * add*())") //Matching method which starts with add prefix for method with any return type.
	//@Before("execution( * add*(com.test.aopdemo.Account))")//Fully qualified Class name should be given for params
	//@Before("execution( * add*(com.test.aopdemo.Account, ..))")//Match method with Account parameter and more params
	//@Before("execution( * add*(..))")//Match method with any number of arguments including zero
	@Before("execution( * com.test.aopdemo.dao.*.*(..))") //Match any method in given package
	public void beforeAddAccountAdvice() {
		System.out.println("======> Executing @Before advice on addAccount()");
	}
}
