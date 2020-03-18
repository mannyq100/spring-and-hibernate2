package com.manny.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.manny.AOPdemo.aspect.AllAopExpressions.forDaoPackageNoGetterSetter()")
	public void peformApiAnalytics() {
		System.out.println("\n======>>> Peforming Api Analytics");
	}
}
