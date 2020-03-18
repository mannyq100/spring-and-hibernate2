package com.manny.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we will add all related advises for logging
	
	// lets start with @BeforeAdvise
	//@Before("execution(public void com.manny.AOPdemo.Account.addAccount())")
	//@Before("execution(public void com.manny.AOPdemo.*.*(..))") math on all methods in a given package
	//@Before("execution(* add*(com.manny.AOPdemo.Account))")
	@Before("execution(* add*(..))")
	public void beforeAccountAdvice() {
		
		System.out.println("\n======>>> Executing before advise on AddAccount()!!");
	}
}
