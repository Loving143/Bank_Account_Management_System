package com.bank.updation.strategypattern;

public interface UpdationBehaviour<Type,T> {
	
	public void update(Type t,T object,Integer id);

}
