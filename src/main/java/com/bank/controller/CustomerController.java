package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AddCustomerRequest;
import com.bank.dto.AddressRequest;
import com.bank.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody AddCustomerRequest request) throws Exception {
		customerService.addCustomer(request);
		return "Customer added successfully";
	}
	
	@PostMapping("/addAddress/{customerId}")
	public String addAddressByCustomerId(@PathVariable Integer customerId,@RequestBody AddressRequest addressRequest) throws Exception {
		
		customerService.addAddressByCustomerId(customerId,addressRequest);
		return "Address added successfully";
	}

}
