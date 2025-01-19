package com.bank.security.auth;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.entity.Admin;
import com.bank.entity.Customer;

public class UserFactory {
	
	@Autowired
	private Customer customer;
	@Autowired
	private Admin admin;
	Object createUser(String type){
		if(type.equals("customer")) {
			return customer;
		}else if(type.equals("admin"))
			return admin;
		return null;
		
	}

}
