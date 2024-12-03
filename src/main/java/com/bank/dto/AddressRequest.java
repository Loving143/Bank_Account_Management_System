package com.bank.dto;

import java.util.Date;

import com.bank.enumm.AddressType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AddressRequest {


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
	private Date updationbDate;
	private String houseNumber;
	private String locality;
	private String pincode;
	private String state;
	
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
		return updationbDate;
	}
	public void setUpdationbDate(Date updationbDate) {
		this.updationbDate = updationbDate;
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
	
	
}
