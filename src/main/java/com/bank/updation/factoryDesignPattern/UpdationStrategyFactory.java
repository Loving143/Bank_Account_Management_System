package com.bank.updation.factoryDesignPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.BadRequestException;
import com.bank.updation.strategypattern.CustomerUpdationStrategy;
import com.bank.updation.strategypattern.UpdationBehaviour;

@Service
public class UpdationStrategyFactory {
	
	@Autowired
	private CustomerUpdationStrategy customerUpdationStrategy;
	
	public UpdationBehaviour getStrategy(String type){
		if(type.equals("customer")) {
			return customerUpdationStrategy;
		}else {
			throw new BadRequestException("No strategy type selected");
		}
		
	}

}
