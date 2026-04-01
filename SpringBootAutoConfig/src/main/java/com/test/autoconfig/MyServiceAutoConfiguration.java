package com.test.autoconfig;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.test.service.MyService;
import com.test.service.MyServiceProperties;

@AutoConfiguration
@EnableConfigurationProperties(MyServiceProperties.class)
public class MyServiceAutoConfiguration {
	@Bean
	@ConditionalOnProperty(prefix = "my.service",name="enabled",
	havingValue = "true",matchIfMissing = true)
	public MyService myservice()
	{
		return new MyService();
	}
}
