package com.bank.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class AddRequest {
	
	private String issuedFrom;
	
	private String lendFrom;

	public String getIssuedFrom() {
		return issuedFrom;
	}

	public void setIssuedFrom(String issuedFrom) {
		this.issuedFrom = issuedFrom;
	}

	public String getLendFrom() {
		return lendFrom;
	}

	public void setLendFrom(String lendFrom) {
		this.lendFrom = lendFrom;
	}
	
	

}
