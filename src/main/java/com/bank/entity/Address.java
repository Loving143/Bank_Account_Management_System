package com.bank.entity;

import java.util.Date;
import java.util.Map;

import com.bank.dto.AddressRequest;
import com.bank.enumm.AddressType;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	private boolean approved;
	private String city;
	private String country;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date creationDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date fromDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date toDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date updationDate;
	private String houseNumber;
	private String locality;
	private String pincode;
	private String state;
	
	public Address(AddressRequest addressRequest) {
		this.setAddressType(addressRequest.getAddressType());
		this.approved= addressRequest.isApproved();
		this.fromDate = addressRequest.getFromDate();
		this.toDate = addressRequest.getToDate();
		this.updationDate = new Date();
		this.locality = addressRequest.getLocality();
		this.houseNumber = addressRequest.getHouseNumber();
		this.pincode = addressRequest.getPincode();
		this.state = addressRequest.getState();
		this.city = addressRequest .getCity();
		this.country = addressRequest.getCountry();
	}
	
	 // Constructor to map data
    public Address(Map<String, Object> data) {
    	
    	String addressTypeStr = (String) data.get("addressType");
        if (addressTypeStr != null) {
            this.addressType = AddressType.valueOf(addressTypeStr); // Enum conversion
        }
        this.approved = (Boolean) data.get("approved");
        this.city = (String) data.get("city");
        this.country = (String) data.get("country");
        this.houseNumber = (String) data.get("houseNumber");
        this.locality = (String) data.get("locality");
        this.pincode = (String) data.get("pincode");
        this.state = (String) data.get("state");
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public AddressType getAddressType() {
		return addressType;
	}


	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}


	public boolean isApproved() {
		return approved;
	}



	public void setApproved(boolean approved) {
		this.approved = approved;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public Date getFromDate() {
		return fromDate;
	}



	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}



	public Date getToDate() {
		return toDate;
	}



	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}



	public Date getUpdationbDate() {
		return updationDate;
	}



	public void setUpdationbDate(Date updationbDate) {
		this.updationDate = updationbDate;
	}



	public String getHouseNumber() {
		return houseNumber;
	}



	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}



	public String getLocality() {
		return locality;
	}



	public void setLocality(String locality) {
		this.locality = locality;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public Address() {
		// TODO Auto-generated constructor stub
	}

	

}
