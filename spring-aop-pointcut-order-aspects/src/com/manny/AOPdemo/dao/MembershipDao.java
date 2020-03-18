package com.manny.AOPdemo.dao;

import org.springframework.stereotype.Component;

import com.manny.AOPdemo.Membership;

@Component
public class MembershipDao {
	

	
	public void addSillyMember() {
		// this.member = new Membership("John", "Doe");
		System.out.println(getClass()+": Silly member added to Membership!");
	}

}
