package com.bank.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bank.dto.AddBranchRequest;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer branchId;
	private String name;
	private String address;
	private String phoneNo;
	private String ifscCode;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;
	
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branch(AddBranchRequest request) {
		this.name = request.getName();
		this.address = request.getAddress();
		this.phoneNo = request.getPhoneNo();
		this.ifscCode = request.getIfscCode();
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	

}
