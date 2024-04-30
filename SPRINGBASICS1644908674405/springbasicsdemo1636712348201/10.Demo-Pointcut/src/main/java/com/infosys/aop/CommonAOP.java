package com.infosys.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonAOP {
	
   
   //pointcut declarations
	@Pointcut("execution(* com.infosys.service.CustomerServiceImpl.updateCustomer(..))")
	public void logUpdateCustomer() {/*pointcut declaration*/}	
		
	@Pointcut("execution(* com.infosys.service.CustomerServiceImpl.deleteCustomer(..))")
	public void logDeleteCustomer() {/*pointcut declaration*/}	
	
	@Pointcut("execution(* com.infosys.service.CustomerServiceImpl.fetchCustomer(..))")
	public void logFetchCustomer() {/*pointcut declaration*/	}

		
	
			


}
