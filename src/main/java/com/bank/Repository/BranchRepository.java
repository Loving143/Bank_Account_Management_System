package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Branch;


public interface BranchRepository extends JpaRepository<Branch,Integer>{

	boolean existsByIfscCode(String ifscCode);

}
