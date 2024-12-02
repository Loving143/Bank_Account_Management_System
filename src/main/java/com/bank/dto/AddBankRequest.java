package com.bank.dto;

import java.util.Date;
import java.util.Set;

import com.bank.entity.Branch;

public class AddBankRequest {

	private String name;
	private String ifscCode;
	private String headOfficeAddress;
	private Integer phoneNumber;
	private String email;
	private Date establishedDate;
	private Set<Branch>branch;
	
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
	public Set<Branch> getBranch() {
		return branch;
	}
	public void setBranch(Set<Branch> branch) {
		this.branch = branch;
	}
	
	
}
