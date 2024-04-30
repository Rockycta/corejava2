/*
 * Demo3:
 * Declare spring profile in pom.xml
 * set active profile in application.properties
 * Activate the profile using maven build
 */
package com.infy.demo3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;



@SpringBootApplication
public class Demo3 {
	public static void main(String[] args) {
		
		
		CustomerService service = null;
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(Demo3.class,
				args);
		service = (CustomerService) context.getBean("CustomerService");
		service.display();			
		
		context.close();
	}		
}
