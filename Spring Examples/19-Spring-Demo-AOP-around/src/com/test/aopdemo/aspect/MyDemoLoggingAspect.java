package com.test.aopdemo.aspect;

import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.test.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.test.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("======> Executing @Before advice on addAccount()");
		
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		
		System.out.println("Method Signature::= "+methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg : args) {
			System.out.println("Parameter ::= "+tempArg);
		}
	}
	
	@AfterReturning(pointcut="execution(* com.test.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("Executing @AfterReturning on method::= "+method);
		
		System.out.println("Result before::= "+result);

		convertAccountNamesToUpperCase(result);//Intercepting the method result...
		
		System.out.println("Result after::= "+result);
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account tempAccount : result) {
			String theUpperCase = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperCase);
		}
	}
	
	@AfterThrowing(pointcut = "execution(* com.test.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExec")
	public void afterThrowingAdvice(JoinPoint theJoinPoint, Throwable theExec) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("========> Executing @AfterThrowing on ::= "+method);
		
		System.out.println("The exception in @AfterThrowing ::= "+theExec);
	}
	
	@After("execution(* com.test.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinally(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("======>Executing @After(Finally) on ::= "+method);
	}
	
	@Around("execution(* com.test.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceddingJoinPoint) throws Throwable {
		
		String method = theProceddingJoinPoint.getSignature().toShortString();
		
		System.out.println("======>Executing @Around on ::= "+method);
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceddingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end-begin;
		
		System.out.println("==>Duration "+(duration / 1000.0));
		
		return result;
		
	}
}
