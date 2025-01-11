package com.bank.fetch.strategypattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repository.AdminRepository;
import com.bank.common.FetchHelper;
import com.bank.dto.AdminDetailsDto;
import com.bank.dto.CustomerDetailsDto;
import com.bank.entity.Admin;
import com.bank.enumm.DynamicResponse;
import com.bank.exception.BadRequestException;

@Service
public class AdminFetchStrategy implements FetchStrategy<Admin>{

	@Autowired 
	private AdminRepository adminRepository;
	
	@Autowired
	private FetchHelper fetchHelper;
	@Override
	public DynamicResponse<Object> fetchById(Integer id) {
		Admin admin =fetchHelper.fetchById(adminRepository, id, "Admin");
		  DynamicResponse<Object> response = new DynamicResponse();
		  response.setStatus("1");
		  response.add("Admin ",admin );
		  return response;
		  
	
	}
	@Override
	public DynamicResponse<Object> fetchEntityDetailsById(Integer id) {
		AdminDetailsDto dto = adminRepository.fetchAdminDetails(id)
					.orElseThrow(()-> new BadRequestException("Admin with the given id not found"));
		DynamicResponse<Object> response = new DynamicResponse();
		response.setStatus("1");
		response.add("name",dto.getName() );
		response.add("password",dto.getPassword());
		response.add("email",dto.getEmail());
		return response;
	}

}
