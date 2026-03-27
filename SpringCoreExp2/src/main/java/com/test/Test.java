package com.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext ctx =new ClassPathXmlApplicationContext("beans.xml");
//		Employee obj = ctx.getBean("emp",Employee.class);
//		System.out.println(obj);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnConfig.class);
		Address adr1 =ctx.getBean("getAdrObj",Address.class);
		adr1.setCity("Hyd");
		adr1.setState("Indian State");
		
		Address adr2 =ctx.getBean("getAdrObj",Address.class);
		adr2.setCity("Mumbai");
		adr2.setState("MH");
		List<Address> l = Arrays.asList(adr1,adr2);
		Employee emp =ctx.getBean("getEmployeeObj",Employee.class);
		emp.setId(11);
		emp.setName("axar");
		emp.setCompany("Bcc");
		emp.setAdr(l);
		
		System.out.println(emp);
		
		
	}

}
