package com.bank.dto;

import java.util.Date;
import com.bank.enumm.AccountType;
import com.bank.enumm.CurrencyType;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bank.entity.Customer;
import com.bank.enumm.AccountType;
import com.bank.enumm.CurrencyType;

public class AddAccountRequest {

	private String accountNumber;
	private AccountType accountType;
	private Integer customerId;
	private Integer bankId;
	private double balance;
	private CurrencyType currency;
	private double minimumbalance;
	private String accountStatus;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date creationDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date lastUpdatedDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date closureDate;
	private double withdrawalAmount;

	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public CurrencyType getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}
	public double getMinimumbalance() {
		return minimumbalance;
	}
	public void setMinimumbalance(double minimumbalance) {
		this.minimumbalance = minimumbalance;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public Date getClosureDate() {
		return closureDate;
	}
	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setWithdrawalAmount(double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	
	
}
