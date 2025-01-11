package com.bank.registration.strategypattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.entity.Person;
import com.bank.exception.BadRequestException;

@Component
public  class RegistrationContext<Type> {
	
	private RegistrationBehaviour<Type>registrationBehaviour;

	public RegistrationBehaviour<Type> getRegistrationBehaviour() {
		return registrationBehaviour;
	}

	public void setRegistrationBehaviour(RegistrationBehaviour<Type> registrationBehaviour) {
		this.registrationBehaviour = registrationBehaviour;
	}
	
	public void Register(Person person,Type t) {
		if(registrationBehaviour == null) {
			throw new BadRequestException("No Registration Strategy set.");
		}
		registrationBehaviour.register(person, t);
	}
	

}
