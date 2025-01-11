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
	}
