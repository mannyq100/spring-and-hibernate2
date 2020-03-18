package com.manny.AOPdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manny.AOPdemo.dao.AccountDao;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// call bean from spring controller
		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
		
		
		// call the business method
		Account myAccount = new Account();
		theAccountDao.addAccount(myAccount, true);
		
		
		// close the context
		context.close();
	}

}
