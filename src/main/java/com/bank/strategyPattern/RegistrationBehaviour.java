package com.bank.strategyPattern;

import com.bank.entity.Person;

public interface RegistrationBehaviour<T> {
	
	void register(Person person,T t);

}
