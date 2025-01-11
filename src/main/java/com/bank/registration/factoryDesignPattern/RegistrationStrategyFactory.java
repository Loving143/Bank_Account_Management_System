package com.bank.registration.factoryDesignPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.registration.strategypattern.AdminRegistrationStrategy;
import com.bank.registration.strategypattern.CustomerRegistrationStrategy;
import com.bank.registration.strategypattern.EmployeeRegistrationStrategy;
import com.bank.registration.strategypattern.RegistrationBehaviour;

@Component
public class RegistrationStrategyFactory {
	
	@Autowired
	private  EmployeeRegistrationStrategy employee;
	
	@Autowired
	private  CustomerRegistrationStrategy customer;
	
	@Autowired
	private  AdminRegistrationStrategy admin;
	
	public  RegistrationBehaviour getStrategy(String type) {
		if (type.equals("employee")) {
            return employee;
        } else if (type.equals("customer")) {
            return customer;
        } else if (type.equals("admin")) {
            return admin;
        } else {
            throw new IllegalArgumentException("No strategy found for this person type");
        }
		
	}

}
