package com.infosys.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	// Pointcut declarations
	@Pointcut("execution(* com.infosys.service.CustomerServiceImpl.fetchCustomer(..))")
	public void logFetchCustomer() {
		/* pointcut declaration */ }

	@Pointcut("within(com.infosys.service.CustomerServiceImpl)")
	public void logall() {
		/* pointcut declaration */}

	@Pointcut("within(com.infosys.service.*)")
	public void logallMethods() {
		/* pointcut declaration */}

	// Aspect methods

	@Before(value = "logallMethods()")
	public void methodOne(JoinPoint joinPoint) {
		logger.info("Within designator , Joinpoint signature :{}", joinPoint.getSignature());
	}

	@Before("com.infosys.aop.CommonAOP.logthis()")
	public void thislog(JoinPoint joinPoint) {
		logger.info("this pointcut designator , Joinpoint signature :{}", joinPoint.getSignature());
	}

	@After(value = "logFetchCustomer() && logall()")
	public void methodAfter(JoinPoint joinPoint) {
		logger.info("Coimbaining pointcuts using &&, Joinpoint signature :{}", joinPoint.getSignature());
	}

}
