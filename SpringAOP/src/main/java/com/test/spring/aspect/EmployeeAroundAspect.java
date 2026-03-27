package com.test.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAroundAspect {	@Around("execution(* com.test.Model.Employee.getName())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
	System.out.println("before invoking getName() method");
	
	Object value = null;
	try {
		value =proceedingJoinPoint.proceed();
		
	}
	catch(Throwable e)
	{
		e.printStackTrace();
	}
	
	System.out.println("After invoking getName() method");
	return value;
	}
}
