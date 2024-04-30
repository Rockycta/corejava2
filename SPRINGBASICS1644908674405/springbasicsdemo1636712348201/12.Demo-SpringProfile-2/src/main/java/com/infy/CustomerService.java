package com.infy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CustomerService")
public class CustomerService {
	private static Logger logger=LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	private Customer customer;
	
	public void displayCustomerID() {
		logger.info(customer.getCustomerID());
	}

}
