package com.bank.fetch.strategypattern;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.Repository.CustomerRepository;
import com.bank.common.FetchHelper;
import com.bank.dto.CustomerDetailsDto;
import com.bank.entity.Customer;
import com.bank.enumm.DynamicResponse;

@Component
public class CustomerFetchStrategy implements FetchStrategy<Customer>{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private FetchHelper fetchHelper;
	
	@Override
	public DynamicResponse<Object> fetchById(Integer id) {
		
		Customer customer = fetchHelper.fetchById(customerRepository, id, "Customer");
//		 CustomerDetailsDto dto = customerRepository.fetchCustomerDetails(id).orElseThrow(null);
		DynamicResponse<Object> response = new DynamicResponse();
		response.setStatus("1");
		response.add("customer",customer );
		return response;
	}

	@Override
	public DynamicResponse<Object> fetchEntityDetailsById(Integer id) {Customer customer = fetchHelper.fetchById(customerRepository, id, "Customer");
	 CustomerDetailsDto dto = customerRepository.fetchCustomerDetails(id).orElseThrow(null);
	DynamicResponse<Object> response = new DynamicResponse();
	response.setStatus("1");
	response.add("name",dto.getName() );
	response.add("password",dto.getPassword() );
	return response;
	}

}
