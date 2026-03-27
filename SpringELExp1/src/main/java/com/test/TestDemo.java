package com.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Student s1 =ctx.getBean("std",Student.class);
		System.out.println(s1);
		
		ExpressionParser exp = new SpelExpressionParser();
		Expression ex = exp.parseExpression("'Simple Spring EL(SPEL) example'");
		String data =ex.getValue(String.class);
//		String str = "Simple Spring EL(SPEL) example";
//		String str1 = new String("Simple Spring EL(SPEL) example");
//		System.out.println(str ==str1);
		System.out.println(data+" Literals");
		Expression ex1 = exp.parseExpression("'Simple Spring EL(SPEL) example'".toUpperCase());
		String dt =ex1.getValue(String.class);
		System.out.println(dt);
		Expression ex2 = exp.parseExpression("500 * 2");
		Integer v =ex2.getValue(Integer.class);
		System.out.println(v);
		System.out.println("1000 * 2");
		
		String v1 ="200";
		String v2="300";
		
		v2.concat(v1);
		
		
		
		
	}

}
