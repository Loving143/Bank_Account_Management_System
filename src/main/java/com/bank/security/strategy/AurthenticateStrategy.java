package com.bank.security.strategy;

import org.springframework.security.core.Authentication;

public interface AurthenticateStrategy {
	
	Authentication authenticate(String username , String password) ;

}
