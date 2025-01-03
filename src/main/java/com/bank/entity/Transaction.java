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

import com.bank.enumm.TransactionStatus;
import com.bank.enumm.TransactionType;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private double transactionAmount;
	private String description;
	private double balanceAfterTransaction;
	@Enumerated(EnumType.STRING)
	TransactionType transactionType;
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;
	@ManyToOne
	private Account account;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}
	public void setBalanceAfterTransaction(double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
