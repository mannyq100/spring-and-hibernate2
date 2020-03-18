package com.manny.AOPdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manny.AOPdemo.dao.AccountDao;
import com.manny.AOPdemo.dao.MembershipDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// call bean from spring controller
		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);

		
		
		// call method to find the accounts
		List<Account> theAccounts = theAccountDao.findAccount(false);
		
		System.out.println("\n\nMain Program : AfterReturning");
		System.out.println("---");
		System.out.println(theAccounts);

		
		
		// close the context
		context.close();
	}

}
