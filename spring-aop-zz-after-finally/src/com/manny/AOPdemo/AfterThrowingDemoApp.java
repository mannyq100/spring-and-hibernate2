package com.manny.AOPdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manny.AOPdemo.dao.AccountDao;
import com.manny.AOPdemo.dao.MembershipDao;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// call bean from spring controller
		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);

		List<Account> theAccounts = null;
		
		// call method to find the accounts
		try {
			boolean tripWire = true;
			theAccountDao.findAccount(tripWire);
		}catch(Exception e) {
			System.out.println("\n Main Program..caught exception: "+e);
		}
		
		System.out.println("\n\nMain Program : AfterThrowingDemoApp");
		System.out.println("---");
		System.out.println(theAccounts);

		
		
		// close the context
		context.close();
	}

}
