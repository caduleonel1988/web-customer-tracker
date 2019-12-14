package br.com.carlos.customertracker.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// Setup Logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// Setup pointcut declarations
	@Pointcut("execution(* br.com.carlos.customertracker.controllers.*.*(..))")
	private void  forControllerPackage() {}
	
	@Pointcut("execution(* br.com.carlos.customertracker.service.*.*(..))")
	private void  forServicePackage() {}

	@Pointcut("execution(* br.com.carlos.customertracker.dao.*.*(..))")
	private void  forDaoPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void  forAppFlow() {}
	 
	// Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		// display the method we are calling 
		String method = joinPoint.getSignature().toShortString();
		logger.info("--------> in @Before: calling method: " + method);
		
		// get the arguments	
		Object[] args = joinPoint.getArgs();
		
		// display the arguments to the method
		for (Object arg : args) {
			logger.info("-------> argument: " + arg);
		}
	}
	
	// Add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		// display the method we are returning from
		String method = joinPoint.getSignature().toShortString();
		logger.info("--------> in @AfterReturning: calling method: " + method);
		
		// display data returned
		logger.info("--------> in result: calling method: " + result);
	}
}
