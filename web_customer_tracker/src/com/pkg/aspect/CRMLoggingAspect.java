package com.pkg.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	@Pointcut("execution(* com.pkg.controller.*.*(..))")
	public void forController() {}

	@Pointcut("execution(* com.pkg.service.*.*(..))")
	public void forService() {}
	
	@Pointcut("execution(* com.pkg.dao.*.*(..))")
	public void forDao() {}
	
	@Pointcut("forController() || forService() || forDao()")
	public void appFlow() {}
	
	@Before("appFlow()")
	public void before(JoinPoint jp)
	{
		Object ob = jp.getSignature().toShortString();
		System.out.println("Method you are calling from :"+ob);
		
		Object[] ob1 = jp.getArgs();
		for(Object temp : ob1)
		{
			System.out.println("Argument passing is :"+temp);
		}
	}
	
	@AfterReturning(pointcut = "appFlow()",
					returning = "result")
	public void after(JoinPoint jp, Object result)
	{
		System.out.println("Returning result is :"+result);
	}
}
