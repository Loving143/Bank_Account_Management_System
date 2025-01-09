package com.bank.strategyPattern;

import org.springframework.stereotype.Component;

import com.bank.entity.Person;
@Component
public class EmployeeRegistrationStrategy<T> implements RegistrationBehaviour<T>{

	@Override
	public void register(Person person, T t) {
		
	}

}
