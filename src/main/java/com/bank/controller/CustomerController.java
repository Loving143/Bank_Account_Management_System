package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.enumm.DynamicResponse;
import com.bank.fetch.factorydesignpattern.FetchClassStrategyFactory;
import com.bank.fetch.factorydesignpattern.FetchStrategyFactory;
import com.bank.services.EntityService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	

	@Autowired
	private EntityService entityService;
	@Autowired
	private FetchClassStrategyFactory fetchClassStrategyFactory;
	@Autowired
	private FetchStrategyFactory fetchStrategyFactory;
	
	@GetMapping("/get/customerDetails/id/{id}")
	@PreAuthorize("hasRole('CUSTOMER')")
	public DynamicResponse fetchCustomerDetails(@PathVariable Integer id){
		DynamicResponse response=  entityService.fetchEntityById(
				fetchClassStrategyFactory.getClassStrategy("customer"), id);
		return 	response;
	}

}
