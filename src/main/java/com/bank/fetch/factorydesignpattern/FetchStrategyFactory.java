package com.bank.fetch.factorydesignpattern;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bank.entity.Admin;
import com.bank.entity.Customer;
import com.bank.fetch.strategypattern.AdminFetchStrategy;
import com.bank.fetch.strategypattern.CustomerFetchStrategy;
import com.bank.fetch.strategypattern.FetchStrategy;

@Component
public class FetchStrategyFactory {

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
}
