package com.bank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bank.dto.AddAccountRequest;
import com.bank.enumm.AccountType;
import com.bank.enumm.CurrencyType;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String accountNumber;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Bank bank;
	private double balance;
	@Enumerated(EnumType.STRING)
	private CurrencyType currency;
	private double minimumbalance;
	private String accountStatus;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date closureDate;
	private double withdrawalAmount;
	private double withDrawnAmount;
	
	public Account(AddAccountRequest request) {
		this.accountNumber = request.getAccountNumber();
		this.accountType =  request.getAccountType();
		this.currency = request.getCurrency();
		this.balance = request.getBalance();
		this.minimumbalance = request.getMinimumbalance();
		this.accountStatus = request.getAccountStatus();
		this.creationDate = request.getCreationDate();
		this.lastUpdatedDate = request.getLastUpdatedDate();
		this.closureDate = request.getClosureDate();
		this.withdrawalAmount = request.getWithdrawalAmount();
	}
	
	public CurrencyType getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public double getWithDrawnAmount() {
		return withDrawnAmount;
	}

	public void setWithDrawnAmount(double withDrawnAmount) {
		this.withDrawnAmount = withDrawnAmount;
	}
	
	

}
