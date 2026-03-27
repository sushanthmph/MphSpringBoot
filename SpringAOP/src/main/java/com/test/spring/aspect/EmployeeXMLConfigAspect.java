package com.test.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class EmployeeXMLConfigAspect {
	public Object employeeAroundAdvice(ProceedingJoinPoint joinPoint)
	{
		System.out.println("EmployeeXMLConfigAspec :: Before invoking getName() ");
		Object value=null;
		try
		{
			value= joinPoint.proceed();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		System.out.println("EmployeeXMLConfigAspec : : After invoking getName()");
		return value;
	}
}
