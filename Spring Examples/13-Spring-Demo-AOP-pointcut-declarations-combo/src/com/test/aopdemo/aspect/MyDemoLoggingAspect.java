package com.test.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//@Before("forDaoPackage()")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("======> Executing @Before advice on addAccount()");
	}
	
	@Pointcut("execution( * com.test.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	//@Before("forDaoPackage()")
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("======> Performing API analytics");
	}
	
	@Pointcut("execution(* com.test.aopdemo.dao.*.get*(..))")
	public void getter() {
		
	}
	
	@Pointcut("execution(* com.test.aopdemo.dao.*.set*(..))")
	public void setter() {
		
	}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
		
	}
}
