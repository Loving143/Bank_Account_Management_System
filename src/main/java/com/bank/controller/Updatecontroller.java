package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.GenericRequest;
import com.bank.response.ResponseMessage;
import com.bank.updation.factoryDesignPattern.UpdationStrategyFactory;
import com.bank.updation.strategypattern.UpdationContext;

@RestController
@RequestMapping("/update")
public class Updatecontroller {

	@Autowired
	private UpdationContext updationContext;
	
	@Autowired
	private UpdationStrategyFactory updationStrategyFactory;
	
	@PutMapping("/updatationType/{updationType}/id/{id}")
	public ResponseEntity<?> update(@PathVariable String updationType,@PathVariable Integer id,@RequestBody Object request ){
		updationContext.setUpdationBehaviour(updationStrategyFactory.getStrategy(updationType));
		updationContext.update(updationType, request,id);
		String type = updationType;
		type = type.substring(0,1);
		type=type.toUpperCase();
		type+=updationType.substring(1);
		return ResponseEntity.ok(new ResponseMessage<>("1",type+" updated successfully"));
	
	}
}
