package com.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.enumm.DynamicResponse;
import com.bank.fetch.factorydesignpattern.FetchStrategyFactory;
import com.bank.fetch.strategypattern.FetchStrategy;

@Service
public class EntityService {

	  @Autowired
	  private FetchStrategyFactory fetchStrategyFactory;

	  public <T> DynamicResponse<Object> fetchEntityById(Class<T> entityClass, Integer id) {
	       FetchStrategy<T> strategy = fetchStrategyFactory.getStrategy(entityClass);
	       return strategy.fetchById(id);
	    }
	  
	  public <T> DynamicResponse<Object> fetchEntityDetailsById(Class<T> entityClass, Integer id) {
	       FetchStrategy<T> strategy = fetchStrategyFactory.getStrategy(entityClass);
	       return strategy.fetchEntityDetailsById(id);
	    }
	  
	  public<T> boolean ExistsByEmail(Class<T> entityClass, String email){
		  FetchStrategy<T> strategy = fetchStrategyFactory.getStrategy(entityClass);
		  return strategy.ExistsByEmail(email);
	  }
	  
	  public<T> boolean ExistsByAadhaarCard(Class<T>entityClass, String aadhaarNo) {
		  FetchStrategy<T>strategy = fetchStrategyFactory.getStrategy(entityClass);
		  return strategy.ExistsByAadhaarCard(aadhaarNo);
	  }
	  
	  public<T> boolean ExistsByPanCard(Class<T>entityClass, String panCard) {
		  FetchStrategy<T>strategy = fetchStrategyFactory.getStrategy(entityClass);
		  return strategy.ExistsByPanCard(panCard);
	  }
	  
	  public<T> boolean ExistsByPhoneNo(Class<T>entityClass, String mobNo) {
		  FetchStrategy<T>strategy = fetchStrategyFactory.getStrategy(entityClass);
		  return strategy.ExistsByMobNo(mobNo);
	  }
	}
