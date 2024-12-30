package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AddAccountRequest;
import com.bank.response.ResponseMessage;
import com.bank.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/createAccount")
	public ResponseEntity<?> createAccount(@RequestBody AddAccountRequest request){
		accountService.createAccount(request);
		return ResponseEntity.ok(new ResponseMessage("1","Account created successfully!"));
	}

}
