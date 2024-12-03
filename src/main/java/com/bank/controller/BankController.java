package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AddBankRequest;
import com.bank.services.BankService;
@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping("/addBank")
	public String addBank(@RequestBody AddBankRequest request){
		bankService.addBank(request);
		return "Bank details added successfully";
	}
	

}
