package com.bank.services;

import com.bank.dto.AddBankRequest;
import com.bank.entity.Bank;

public class BankServiceImpl implements BankService{

	@Override
	public void addBank(AddBankRequest request) {
		
		Bank bank = new Bank(request);
		
	}

}
