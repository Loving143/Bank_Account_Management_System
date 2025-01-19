package com.bank.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.bank.exception.BadRequestException;

@Component
public class FetchUserDetailsServiceFactory {
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	@Autowired
	private AdminUserDetailsService adminUserDetailsService;
	
	public UserDetailsService fetchUserDetailsService(String userType)   {
		if(userType.equals("customer"))
			return customerUserDetailsService;
		else if(userType.equals("admin"))
			return adminUserDetailsService;
		else {
			throw new BadRequestException("No valid userType selected!");
		}
	}

}
