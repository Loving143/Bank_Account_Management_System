package com.bank.services;

import java.util.List;

import com.bank.dto.AddCustomerRequest;
import com.bank.dto.AddressRequest;
import com.bank.entity.Address;

public interface CustomerService {

	void addCustomer(AddCustomerRequest request) throws Exception;

	void addAddressByCustomerId(Integer customerId, AddressRequest addressRequest) throws Exception;

	List<Address> addressHistoryByCustomerId(Integer customerId);

	List<Address> currentAddressHistoryByCustomerId(Integer customerId);

	List<Address> permanentAddressHistoryByCustomerId(Integer customerId);

}
