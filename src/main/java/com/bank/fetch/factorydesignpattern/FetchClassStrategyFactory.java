package com.bank.fetch.factorydesignpattern;

import org.springframework.stereotype.Component;

import com.bank.entity.Admin;
import com.bank.entity.Customer;
import com.bank.exception.BadRequestException;

@Component
public class FetchClassStrategyFactory<T> {
	
	public Class<T> getClassStrategy(String classType) {
		if(classType.equals("customer"))
			return (Class<T>) Customer.class;
		else if(classType.equals("admin"))
			return (Class<T>) Admin.class;
		else {
			throw new BadRequestException("No appropriate class type selected");
		}
	}

}
