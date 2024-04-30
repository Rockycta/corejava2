package com.infy.demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
@Aspect
public class TestLogging {	
	private static Logger logger=LoggerFactory.getLogger(TestLogging.class);
	
	@Before("execution(* com.infy.demo3.CustomerService.display(..))")
	public void logTest(JoinPoint joinPoint) {
		logger.info("Testing Environment:");
	}
 	
}
