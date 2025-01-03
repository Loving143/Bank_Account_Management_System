package com.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repository.AccountRepository;
import com.bank.Repository.BankRepository;
import com.bank.Repository.CustomerRepository;
import com.bank.dto.AddAccountRequest;
import com.bank.entity.Account;
import com.bank.entity.Bank;
import com.bank.entity.Customer;
import com.bank.enumm.AccountType;
import com.bank.enumm.CurrencyType;
import com.bank.exception.BadRequestException;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BankRepository bankRepository;
	@Override
	public void createAccount(AddAccountRequest request) {
		validateAccount(request);
		Customer customer= customerRepository.findById(request.getCustomerId())
					.orElseThrow(()-> new BadRequestException("Customer Id does not exists!"));
		if(!customer.isVerified())
			throw new BadRequestException("Customer is not verified.Account can not be opened for this customer!");
		Bank bank = bankRepository.findById(request.getBankId())
					.orElseThrow(()-> new BadRequestException("Bank Id does not exists!"));
		
		Account account = new Account(request);
		account.setCustomer(customer);
		account.setBank(bank);
		account.setAccountType(AccountType.CURRENT_ACCOUT);
		account.setCurrency(CurrencyType.INR);
		accountRepository.save(account);
	}
	
	public void validateAccount(AddAccountRequest request) {
		if(accountRepository.existsByAccountNumber(request.getAccountNumber())) {
			throw new BadRequestException("Account number already exists!");
		}
		
		
	}

}
