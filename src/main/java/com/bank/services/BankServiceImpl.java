package com.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repository.BankRepository;
import com.bank.dto.AddBankRequest;
import com.bank.entity.Bank;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public void addBank(AddBankRequest request) {
		
		Bank bank = new Bank(request);
		bankRepository.save(bank);
	}
}
