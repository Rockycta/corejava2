package com.infy;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.dto.CustomerDTO;
import com.infy.service.CustomerServiceImpl;



@SpringBootApplication
public class H2demoApplication implements CommandLineRunner {

	public static final Log LOGGER = LogFactory.getLog(H2demoApplication.class);

	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(H2demoApplication.class, args);
	}
	
	public void run(String... args) throws Exception {

		addCustomer();

	}
	public void addCustomer() {

		CustomerDTO customer = new CustomerDTO();
		customer.setCustomerId(4);
		customer.setEmailId("natR@infy.com");
		customer.setFirstName("Natasha");
		customer.setLastName("Romanoff");
		
		try {
			customerService.addCustomer(customer);
			LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS"));
		} catch (Exception e) {

			if (e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}

}
}
