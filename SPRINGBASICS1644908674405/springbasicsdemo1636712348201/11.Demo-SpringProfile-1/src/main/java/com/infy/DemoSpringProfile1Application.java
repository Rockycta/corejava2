/*
 * Demo 1:
 * @Profile in class level
 * Environment based application.properties
 * Set active profile using application.properties
 */
package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;


@SpringBootApplication
public class DemoSpringProfile1Application {

	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(DemoSpringProfile1Application.class,
				args);
		
		/*DEVELOPMENT ENVIRONMENT*/
		CustomerDev service = (CustomerDev) context.getBean("CustomerDev");
		service.insertCustomerDev();
		
		
		/*PRODUCTION ENVIRONMENT*/
//		CustomerProd service1 = (CustomerProd) context.getBean("CustomerProd");
//		service1.insertCustomer();
		
		
		context.close();
	}

}
