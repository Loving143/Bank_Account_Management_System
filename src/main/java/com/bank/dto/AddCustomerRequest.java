package com.bank.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.bank.entity.Address;

public class AddCustomerRequest {

	private String name;
	private String email;
	private String phoneNo;
	private Set<Address> addresses ;
	private String panCard;
	private String aadhaarCard;
	private Set<AddDocumentRequest> documents;
	private Integer age;
	
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
	public Set<AddDocumentRequest> getDocuments() {
		return documents;
	}
	public void setDocuments(Set<AddDocumentRequest> documents) {
		this.documents = documents;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
