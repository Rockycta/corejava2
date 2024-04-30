package com.infy.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("CustomerService")
public class CustomerService {
	private static Logger logger=LoggerFactory.getLogger(CustomerService.class);
	public void display() {
		logger.info("Customer Added sucessfully");
		
	}

}
