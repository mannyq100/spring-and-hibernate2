package com.manny.AOPdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.manny.AOPdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceLevel;
		
	public String getName() {
		System.out.println("In getAccountName method");
		return name;
	}

	public void setName(String name) {
		System.out.println("In setAccountName method");
		this.name = name;
	}

	public String getServiceLevel() {
		System.out.println("In getAccountServiceCode method");
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		System.out.println("In setAccountServiceCode method");
		this.serviceLevel = serviceLevel;
	}

	public void addAccount(Account theAccount, Boolean vipFlag) {
		
		System.out.println(getClass()+": Doing my DB work: Adding an account.");
	}
	
	
	public List<Account> findAccount() {
		
		List<Account> myAccounts = new ArrayList<>() ;
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Mary", "Gold");
		Account temp3 = new Account("Jose", "Bronze");

		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	

}
