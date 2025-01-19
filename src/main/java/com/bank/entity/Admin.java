package com.bank.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Admin extends Person{

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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Admin () {
		
	}
	public Admin (Map<String,Object>data) {
	super();
	this.setUserName((String)data.get("name"));
	this.setEmail((String)data.get("email"));
	this.phoneNo = (String)data.get("phoneNo");
	this.aadhaarCard =(String)data.get("aadhaarCard");
	this.age = (Integer)data.get("age");
	this.panCard = (String)data.get("panCard");
    List<Map<String, Object>> addressList = (List<Map<String, Object>>) data.get("addresses");
    if (addressList != null) {
        this.addresses = addressList.stream()
                                    .map(Address::new) // Use Address constructor to convert each map
                                    .collect(Collectors.toSet());
    } else {
        this.addresses = new HashSet<>(); // Default to an empty set if addresses are null
    }
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
