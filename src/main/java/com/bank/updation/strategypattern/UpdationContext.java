package com.bank.updation.strategypattern;

import org.springframework.stereotype.Component;

import com.bank.exception.BadRequestException;

@Component
public class UpdationContext<Type  ,T > {
	
	UpdationBehaviour<Type,T> updationBehaviour;

	public UpdationBehaviour<Type,T> getUpdationBehaviour() {
		return updationBehaviour;
	}

	public void setUpdationBehaviour(UpdationBehaviour<Type,T> updationBehaviour) {
		this.updationBehaviour = updationBehaviour;
	}
	
	public void update(Type type,T t,Integer id) {
		if(updationBehaviour == null) {
			throw new BadRequestException("No strategy type selected!");
		}
		updationBehaviour.update(type,t,id);
	}

	
}
