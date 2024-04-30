package com.infy.demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
@Aspect
public class DevLogging {	
	private static Logger logger=LoggerFactory.getLogger(DevLogging.class);
	
	@Before("execution(* com.infy.demo3.CustomerService.display(..))")
	public void logDev(JoinPoint joinPoint) {		
		logger.info("Developement Environment:");
	}
	
}
