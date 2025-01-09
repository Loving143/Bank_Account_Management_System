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
public class Customer extends Person{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String phoneNo;
	@OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Address> addresses ;
	private String panCard;
	private String aadhaarCard;
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean verified;
	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	private Set<Document>documents;
	private Integer age;
	@OneToMany(cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private Set<Role>roles;
	
	public Customer() {
		super();
	}
	public Customer(AddCustomerRequest request , Set<Document> docs ) {
		super(request.getName(),request.getPassword(),request.getEmail());
		this.phoneNo = request.getPhoneNo();
		this.panCard = request.getPanCard();
		this.aadhaarCard = request.getAadhaarCard();
		this.addresses = request.getAddresses();
		this.documents = docs;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public Set<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
