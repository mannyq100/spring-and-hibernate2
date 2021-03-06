package com.manny.AOPdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manny.AOPdemo.dao.AccountDao;
import com.manny.AOPdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ConfigAop.class);
		
		// call bean from spring controller
		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
		MembershipDao theMemberDao = context.getBean("membershipDao", MembershipDao.class);

		
		
		// call the business method
		Account myAccount = new Account();
		
		theAccountDao.addAccount(myAccount, true);

		
	theAccountDao.setName("foobar");
	theAccountDao.setServiceLevel("silver");

	String code = theAccountDao.getServiceLevel();
	String name = theAccountDao.getName();
	
	
	theMemberDao.addSillyMember();
		
		
		// close the context
		context.close();
	}

}
