package com.bank.entity;

import java.util.Date;
import java.util.Set;

import com.bank.dto.AddBankRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bankId;
	private String name;
	private String ifscCode;
	private String headOfficeAddress;
	private Integer phoneNumber;
	private String email;
	private Date establishedDate;
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "bank")
	private Set<Branch>branch;
	
	
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getHeadOfficeAddress() {
		return headOfficeAddress;
	}
	public void setHeadOfficeAddress(String headOfficeAddress) {
		this.headOfficeAddress = headOfficeAddress;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEstablishedDate() {
		return establishedDate;
	}
	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}
	public Bank() {
	}
	public Bank(AddBankRequest request) {
		this.name = request.getName();
		this.email = request.getEmail();
		this.establishedDate = request.getEstablishedDate();
		this.ifscCode = request.getIfscCode();
		this.headOfficeAddress = request.getHeadOfficeAddress();
		this.phoneNumber = request.getPhoneNumber();
		this.branch = request.getBranch();
	}
	
	

}
