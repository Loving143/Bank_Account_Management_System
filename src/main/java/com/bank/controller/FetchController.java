package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.enumm.DynamicResponse;
import com.bank.fetch.factorydesignpattern.FetchClassStrategyFactory;
import com.bank.fetch.factorydesignpattern.FetchStrategyFactory;
import com.bank.services.EntityService;

@RestController
@RequestMapping("/fetch")
public class FetchController {
	
	@Autowired
	private EntityService entityService;
	@Autowired
	private FetchStrategyFactory fetchStrategyFactory;
	
	@Autowired
	private FetchClassStrategyFactory fetchClassStrategyFactory;
	
	@GetMapping("/fetchById/type/{type}/id/{id}")
	public DynamicResponse dynamicFetchById(@PathVariable String type , @PathVariable Integer id){
		DynamicResponse response=  entityService.fetchEntityById(fetchClassStrategyFactory.getClassStrategy(type), id);
	return 	response;
	}

	@GetMapping("/fetchEntityDetailsById/type/{type}/id/{id}")
	public DynamicResponse dynamicFetchEntityDetailsById(@PathVariable String type,@PathVariable Integer id) {
		DynamicResponse response=  entityService.fetchEntityDetailsById(fetchClassStrategyFactory.getClassStrategy(type), id);
			return 	response;
	}
	

}
