package com.bank.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bank.dto.AddBankRequest;

@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bankId;
	private String name;
	private String ifscCode;
	private String headOfficeAddress;
	private String phoneNumber;
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
		this.headOfficeAddress = request.getHeadOfficeAddress();
		this.phoneNumber = request.getPhoneNumber();
		this.branch = request.getBranch();
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set<Branch> getBranch() {
		return branch;
	}
	public void setBranch(Set<Branch> branch) {
		this.branch = branch;
	}
	
	

}
