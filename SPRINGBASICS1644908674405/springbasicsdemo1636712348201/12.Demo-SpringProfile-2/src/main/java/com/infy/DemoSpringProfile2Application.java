/*
 * Demo 2:
 * @Profile in method level 
 * @Profile ! NOT operator
 * Set active profile using JVM system property
 * 
 */
package com.infy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class DemoSpringProfile2Application {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test");
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(DemoSpringProfile2Application.class,
				args);	
		
		CustomerService service= (CustomerService) context.getBean("CustomerService");
		service.displayCustomerID();
		
	}

}
