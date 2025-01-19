package com.bank.fetch.factorydesignpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bank.Repository.AdminRepository;
import com.bank.Repository.CustomerRepository;

@Component
public class FetchRepositoryStrategyFactory<T> {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CustomerRepository customerRepository;
	public JpaRepository<T, Integer>fetchRepository(String entityType){
		if(entityType.equals("admin")) {
			return (JpaRepository<T, Integer>) adminRepository;
		}else if(entityType.equals("customer"))
			return (JpaRepository<T, Integer>)customerRepository;
		return null;
	}

}
