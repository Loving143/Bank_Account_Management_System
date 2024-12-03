package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AddBranchRequest;
import com.bank.services.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	@PostMapping("/addBranch")
	public String addBranch(@RequestBody AddBranchRequest request) throws Exception {
		branchService.addBranch(request);
		return "Branch added successfully";
		
	}

}
