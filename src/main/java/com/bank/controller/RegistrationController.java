package com.bank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.GenericFilterRequest;
import com.bank.registration.factoryDesignPattern.PersonStrategyFactory;
import com.bank.registration.factoryDesignPattern.RegistrationStrategyFactory;
import com.bank.registration.strategypattern.RegistrationContext;
import com.bank.response.ResponseMessage;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private RegistrationContext context;
	
	
	@Autowired
	private RegistrationStrategyFactory strategyFactory;
	
	@PostMapping("/registrationType/{registrationType}")
	public ResponseEntity<?> registration(@PathVariable String registrationType,@RequestBody Object request ){
		
		context.setRegistrationBehaviour(strategyFactory.getStrategy(registrationType));
		context.Register(PersonStrategyFactory.getPerson(registrationType), request);
		String type = registrationType;
		type = type.substring(0,1);
		type=type.toUpperCase();
		type+=registrationType.substring(1);
		return ResponseEntity.ok(new ResponseMessage<>("1",type+" registered successfully"));
	}
	
	@PostMapping("/filter")
	public ResponseEntity<?> filter(@RequestBody GenericFilterRequest request){
		 Map<String, Object> filters = request.getFilters();

		 System.out.println("issuedUpto "+request.getRequest().getIssuedFrom());
	        if (filters != null && !filters.isEmpty()) {
	            filters.forEach((key, value) -> 
	                System.out.println("Filter Key: " + key + ", Filter Value: " + value)
	            );
	        } else {
	            System.out.println( "No filters provided!");
	        }
	       // System.out.println( "No filters provided!");
	        
	        return ResponseEntity.ok(new ResponseMessage<>("1","Filters registered successfully"));
	    }
	}


