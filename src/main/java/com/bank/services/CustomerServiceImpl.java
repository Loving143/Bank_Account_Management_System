package com.bank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repository.CustomerRepository;
import com.bank.dto.AddCustomerRequest;
import com.bank.dto.AddressRequest;
import com.bank.entity.Address;
import com.bank.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void addCustomer(AddCustomerRequest request) {
		
		Customer customer = new Customer(request);
		customerRepository.save(customer);
		
	}

	@Override
	public void addAddressByCustomerId(Integer customerId, AddressRequest addressRequest) throws Exception {
		
		Address address = new Address(addressRequest);
		Optional<Customer>customer = customerRepository.findById(customerId);
		if(customer.isEmpty()) {
			throw new Exception("Customer does not exists!");
		}else {
			Customer cust = customer.get();
			cust.getAddresses().add(address);
			customerRepository.save(cust);
		}
	}
	
	

}
