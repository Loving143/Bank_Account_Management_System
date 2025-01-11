package com.bank.fetch.strategypattern;

import com.bank.entity.Admin;
import com.bank.enumm.DynamicResponse;

public interface FetchStrategy<T> {
	
	DynamicResponse<Object> fetchById(Integer id);
	DynamicResponse<Object> fetchEntityDetailsById(Integer id);

}
