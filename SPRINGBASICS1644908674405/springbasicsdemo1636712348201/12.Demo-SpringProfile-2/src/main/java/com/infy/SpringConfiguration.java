package com.infy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SpringConfiguration {
	
	@Profile("prod")
	@Bean("customer")
	public Customer customerProd() {
		return new Customer("PROD101");
	}
	
	@Profile("dev")
	@Bean("customer")
	public Customer customerDev() {
		return new Customer("DEV101");
	}
	
	@Profile("test")
	@Bean("customer")
	public Customer customerTest() {
		return new Customer("TEST101");
	}

}
