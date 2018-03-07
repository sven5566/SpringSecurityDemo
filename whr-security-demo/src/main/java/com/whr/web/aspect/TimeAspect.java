package com.whr.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	@Around("execution(* com.whr.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("time aspect start");
		Object obj=pjp.proceed();
		Object [] args=pjp.getArgs();
		for(Object arg:args) {
			System.out.println("arg is="+arg);
		}
		System.out.println("time aspect end");
		return obj;
	}
	
}
