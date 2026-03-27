package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AnnConfig {
	@Bean
	@Scope(scopeName ="prototype")
	public Address getAdrObj()
	{
		return new Address();
	}
	@Bean
	public Employee getEmployeeObj()
	{
		return new Employee();
	}
}
