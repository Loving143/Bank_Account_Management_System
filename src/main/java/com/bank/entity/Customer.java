package com.bank.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.bank.dto.AddCustomerRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer extends Person{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String phoneNo;
	@OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
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
	
	public <T> Customer(Map<String, Object> data) {
		super();
		this.setUserName((String)data.get("name"));
		this.setEmail((String)data.get("email"));
		this.phoneNo = (String)data.get("phoneNo");
		this.panCard = (String)data.get("panCard");
		this.aadhaarCard =(String)data.get("aadhaarCard");
		this.age = (Integer)data.get("age");
	    List<Map<String, Object>> addressList = (List<Map<String, Object>>) data.get("addresses");
	    if (addressList != null) {
	        this.addresses = addressList.stream()
	                                    .map(Address::new) // Use Address constructor to convert each map
	                                    .collect(Collectors.toSet());
	    } else {
	        this.addresses = new HashSet<>(); // Default to an empty set if addresses are null
	    }
	    
	    List<Map<String, Object>> roles = (List<Map<String, Object>>) data.get("roles");
	    if (roles != null) {
	        this.roles = roles.stream()
	                                    .map(Role::new) // Use Address constructor to convert each map
	                                    .collect(Collectors.toSet());
	    } else {
	        this.roles = new HashSet<>(); // Default to an empty set if addresses are null
	    }
		
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Customer(String userName, String password, String email) {
		super(userName, password, email);
		// TODO Auto-generated constructor stub
	}

}
