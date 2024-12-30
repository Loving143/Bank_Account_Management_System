package com.bank.services;

import org.springframework.stereotype.Service;

import com.bank.dto.AddAccountRequest;

@Service
public class AccountServiceImpl implements AccountService{

	@Override
	public void createAccount(AddAccountRequest request) {
		validateAccount(request);
		
	}

	private void validateAccount(AddAccountRequest request) {

		
	}

}
