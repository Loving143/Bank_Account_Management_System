package com.bank.factoryDesignPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.strategyPattern.AdminRegistrationStrategy;
import com.bank.strategyPattern.CustomerRegistrationStrategy;
import com.bank.strategyPattern.EmployeeRegistrationStrategy;
import com.bank.strategyPattern.RegistrationBehaviour;

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
