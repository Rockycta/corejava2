package com.infy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("CustomerProd")
@Profile("prod")
public class CustomerProd {
	private static final Log logger=LogFactory.getLog(CustomerProd.class);
	@Autowired
	 Environment environment;

	public CustomerProd() {
		logger.info("Customer bean for production environment");
}	
	public void insertCustomer() {
		logger.info(environment.getProperty("message"));
	}
}