package com.infosys.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonAOP {
	
   
   //pointcut declarations
	@Pointcut("this(com.infosys.service.CustomerService)")
	public void logthis() {/*pointcut declaration*/}		


}
