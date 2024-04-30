package com.infy;

import java.text.DateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!prod")
@Component
@Aspect
public class LoggingAspect {
	private static Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@After("execution(* com.infy.CustomerService.displayCustomerID(..))")
	public void logAfterAdvice(JoinPoint joinPoint) {
		logger.info("In After Advice, Joinpoint signature :{}", joinPoint.getSignature());
		long time = System.currentTimeMillis();
		String date = DateFormat.getDateTimeInstance().format(time);
		logger.info("Report generated at time {}", date);
	}

	@Before("execution(* com.infy.CustomerService.displayCustomerID(..))")
	public void logBeforeAdvice(JoinPoint joinPoint) {		
		logger.info("In Before Advice, Joinpoint signature :{}", joinPoint.getSignature());
		long time = System.currentTimeMillis();
		String date = DateFormat.getDateTimeInstance().format(time);
		logger.info("Report generated at time:{}", date);

	}

}
