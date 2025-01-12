package com.bank.fetch.strategypattern;

import com.bank.entity.Admin;
import com.bank.enumm.DynamicResponse;

public interface FetchStrategy<T> {
	
	DynamicResponse<Object> fetchById(Integer id);
	DynamicResponse<Object> fetchEntityDetailsById(Integer id);
	boolean ExistsByEmail(String email);
	boolean ExistsById(Integer id);
	boolean ExistsByMobNo(String mobNo);
	boolean ExistsByAadhaarCard(String aadhaarNo);
	boolean ExistsByPanCard(String panCard);
	

}
