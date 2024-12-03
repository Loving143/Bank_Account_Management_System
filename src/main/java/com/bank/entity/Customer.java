package com.bank.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bank.dto.AddCustomerRequest;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String phoneNo;
	@OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Address> addresses ;
	private String panCard;
	private String aadhaarCard;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(AddCustomerRequest request) {
		this.name = request.getName();
		this.email = request.getEmail();
		this.phoneNo = request.getPhoneNo();
		this.panCard = request.getPanCard();
		this.aadhaarCard = request.getAadhaarCard();
		this.addresses = request.getAddresses();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getAadhaarCard() {
		return aadhaarCard;
	}
	public void setAadhaarCard(String aadhaarCard) {
		this.aadhaarCard = aadhaarCard;
	}

}
