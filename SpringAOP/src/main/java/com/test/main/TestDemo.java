package com.test.main;
import com.test.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeService service = ctx.getBean("employeeService",EmployeeService.class);
		System.out.println(service.getEmployee().getName());
		service.getEmployee().setName("Rohit Sharma");
		//service.getEmployee().throwException();
		
	}

}
