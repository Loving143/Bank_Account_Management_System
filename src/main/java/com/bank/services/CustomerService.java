package com.bank.services;

import com.bank.dto.AddCustomerRequest;
import com.bank.dto.AddressRequest;

public interface CustomerService {

	void addCustomer(AddCustomerRequest request);

	void addAddressByCustomerId(Integer customerId, AddressRequest addressRequest) throws Exception;

}
