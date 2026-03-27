package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		Employee obj =ctx.getBean("emp",Employee.class);
//		System.out.println(obj);
//		
//		Employee obj1 =(Employee)ctx.getBean("emp1");
//		System.out.println(obj1);
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnConfig.class);
		Employee obj1 =ctx.getBean("getSetterObj",Employee.class);
		Employee obj2 =ctx.getBean("getConstructorObj",Employee.class);
		obj1.setId(2);
		obj1.setCompany(obj2.getCompany());

		obj1.setName(obj2.getName());

		System.out.println("SetterInjection : "+obj1);
		System.out.println("ConstructorInjection : "+obj2);
	}

}
