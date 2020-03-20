package com.test.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

	@Pointcut("execution( * com.test.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
		
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
