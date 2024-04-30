package com.infosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.support.AbstractApplicationContext;

import com.infosys.dto.CustomerDTO;
import com.infosys.service.CustomerServiceImpl;


@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	CustomerServiceImpl service = null;
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(App.class,
				args);
		service = (CustomerServiceImpl) context.getBean("customerService");
		service.fetchCustomer();
		CustomerDTO cust=new CustomerDTO(987638,"Jason","jason@gmail.com","India");
		service.createCustomer(cust);
		
		CustomerDTO cust1=new CustomerDTO(987638,"Jason","jason@yahoo.com","US");		
		service.updateCustomer(987638, cust1);
		context.close();
    }
}
