package com.bank.security.auth;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.Repository.CustomerRepository;
import com.bank.entity.Customer;
import com.bank.exception.BadRequestException;
@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	      
    	Customer customer = customerRepository.findByUserName(username).
    			orElseThrow(()->new BadRequestException("Customer with this username not found"));
    	return new CustomUserDetails(customer);
	    
	}
	}
