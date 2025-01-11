package com.bank.dto;

import java.util.Set;

import com.bank.entity.Address;

public interface CustomerDetailsDto {
	
	String getName();
	String getPassword();
	Set<Address> getAddress();
	

}
