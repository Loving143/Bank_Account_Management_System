package com.bank.dto;

import java.util.Date;
import java.util.Set;

import com.bank.entity.Branch;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AddBankRequest {

	private String name;
	private String headOfficeAddress;
	private String phoneNumber;
	private String email;
	@JsonFormat(pattern ="dd-MM-yyyy")
	private Date establishedDate;
	private Set<Branch>branch;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Set<Branch> getBranch() {
		return branch;
	}
	public void setBranch(Set<Branch> branch) {
		this.branch = branch;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
