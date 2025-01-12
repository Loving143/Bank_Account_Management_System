package com.bank.fetch.factorydesignpattern;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bank.Repository.AdminRepository;
import com.bank.Repository.CustomerRepository;
import com.bank.entity.Admin;
import com.bank.entity.Customer;
import com.bank.exception.BadRequestException;
import com.bank.fetch.strategypattern.AdminFetchStrategy;
import com.bank.fetch.strategypattern.CustomerFetchStrategy;
import com.bank.fetch.strategypattern.FetchStrategy;

@Component
public class FetchStrategyFactory<T> {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	private final Map<Class<?>,FetchStrategy<?>>strategyMap = new HashMap<>();
	
	public FetchStrategyFactory(AdminFetchStrategy adminFetchStrategy, CustomerFetchStrategy customerFetchStrategy) {
        strategyMap.put(Admin.class, adminFetchStrategy);
        strategyMap.put(Customer.class, customerFetchStrategy);
    }

    @SuppressWarnings("unchecked")
    public <T> FetchStrategy<T> getStrategy(Class<T> entityClass) {
        FetchStrategy<T> strategy = (FetchStrategy<T>) strategyMap.get(entityClass);
        if (strategy == null) {
            throw new IllegalArgumentException("No fetch strategy found for entity class: " + entityClass.getName());
        }
        return strategy;
    }
    
    public boolean fetchExistsByEmailStrategy(JpaRepository<T, Integer> repository,String entityName,String email){
    	if(entityName.equals("customer")) {
    		return ((CustomerRepository)repository).existsByEmail(email);
    	}else if(entityName.equals("admin")) {
    		return ((AdminRepository)repository).existsByEmail(email);
    	}else {
    		throw new BadRequestException("No repository found");
    	}
    	
    }
    
    public boolean fetchExistsByAdhaarCardStrategy(JpaRepository<T, Integer> repository,String entityName,String aadhaarCard){
    	if(entityName.equals("customer")) {
    		return ((CustomerRepository)repository).existsByAadhaarCard(aadhaarCard);
    	}else if(entityName.equals("admin")) {
    		return ((AdminRepository)repository).existsByAadhaarCard(aadhaarCard);
    	}else {
    		throw new BadRequestException("No repository found");
    	}
    	
    }
    
    public boolean fetchExistsByPancardStrategy(JpaRepository<T, Integer> repository,String entityName,String pancard){
    	if(entityName.equals("customer")) {
    		return ((CustomerRepository)repository).existsByPanCard(pancard);
    	}else if(entityName.equals("admin")) {
    		return ((AdminRepository)repository).existsByPanCard(pancard);
    	}else {
    		throw new BadRequestException("No repository found");
    	}
    	
    }
    
    public boolean fetchExistsByMobNoStrategy(JpaRepository<T, Integer> repository,String entityName,String pancard){
    	if(entityName.equals("customer")) {
    		return ((CustomerRepository)repository).existsByPhoneNo(pancard);
    	}else if(entityName.equals("admin")) {
    		return ((AdminRepository)repository).existsByPhoneNo(pancard);
    	}else {
    		throw new BadRequestException("No repository found");
    	}
    	
    }

	public boolean fetchExistsByIdStrategy(JpaRepository<T, Integer> repository, String entityName, Integer id) {
		if(entityName.equals("customer")) {
    		return ((CustomerRepository)repository).existsById(id);
    	}else if(entityName.equals("admin")) {
    		return ((AdminRepository)repository).existsById(id);
    	}else {
    		throw new BadRequestException("No repository found");
    	}
	}
    
    
}
