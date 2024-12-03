package com.bank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repository.BankRepository;
import com.bank.Repository.BranchRepository;
import com.bank.dto.AddBranchRequest;
import com.bank.entity.Bank;
import com.bank.entity.Branch;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	@Autowired
	private BankRepository bankRepository;

	@Override
	public void addBranch(AddBranchRequest request) throws Exception {
		validateBranch(request);
		Optional<Bank> bank = bankRepository.findById(request.getBankId());
		if(bank.isEmpty()) {
			throw new Exception("Bank with the given bank id "+request.getBankId()+" does not exists!");
		}else {
			Branch branch = new Branch(request);
			branch.setBank(bank.get());
			branchRepository.save(branch);
		}
		
	}
	
	public  void validateBranch(AddBranchRequest request) throws Exception {
		if(branchRepository.existsByIfscCode(request.getIfscCode())) {
			throw new Exception("Branches IFSC Code can not be the same!");
		}
	}
	
	
}
