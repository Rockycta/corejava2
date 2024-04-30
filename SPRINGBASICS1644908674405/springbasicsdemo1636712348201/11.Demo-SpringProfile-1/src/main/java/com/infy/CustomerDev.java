package com.infy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("CustomerDev")
@Profile("dev")
public class CustomerDev {
	private static final Log logger=LogFactory.getLog(CustomerDev.class);
	 @Autowired
	 Environment environment;

	public CustomerDev() {
		logger.info("Customer bean for development environment");
	}
	
	public void insertCustomerDev() {
		logger.info(environment.getProperty("message"));
	}	

}
