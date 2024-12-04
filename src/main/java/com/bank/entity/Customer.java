package com.bank.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean verified;
	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	private Set<Document>documents;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(AddCustomerRequest request , Set<Document> docs ) {
		this.name = request.getName();
		this.email = request.getEmail();
		this.phoneNo = request.getPhoneNo();
		this.panCard = request.getPanCard();
		this.aadhaarCard = request.getAadhaarCard();
		this.addresses = request.getAddresses();
		this.documents = docs;
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
