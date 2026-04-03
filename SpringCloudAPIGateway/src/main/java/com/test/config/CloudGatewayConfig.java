package com.test.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudGatewayConfig {
	
	@Bean
	protected RouteLocator routeLocatorConfig(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route(r -> r.path("/service1/*")
						.uri("http://localhost:7576/*"))
				
				.route(r -> r.path("/service2/*")
						.uri("http://localhost:7577/*"))
				
				.route(r -> r.path("/service3/*")
						.uri("http://localhost:7578/*"))
				.build();
				
	}
}
