package com.test.spring.aspect;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspectJoinPoint {
	@Before("execution(public void com.test.model..set*(*))")
	public void loggingAdvice(JoinPoint joinpoint)
	{
		System.out.println("Before exceuting logging advice on method : "+joinpoint.toString());
		System.out.println("Arguments passed :" +Arrays.toString(joinpoint.getArgs()));
		
	}
	@Before("args(name)")
	public void logStringArguments(String name)
	{
		System.out.println("String arguments passed : "+name);
		
	}
}
