package com.bank.registration.factoryDesignPattern;

import com.bank.entity.Admin;
import com.bank.entity.Customer;
import com.bank.entity.Employee;
import com.bank.entity.Person;

public class PersonStrategyFactory {
	
	public static Person getPerson(String type) {
		if(type.equals("employee")) {
			return new Employee();
		}else if(type.equals("admin")) {
			return new Admin();
		}else if(type.equals("customer")) {
			return new Customer();
		}else {
			throw new IllegalArgumentException("No Person found for this person type");
		}
	}

}
