package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Bank;

public interface BankRepository extends JpaRepository<Bank,Integer> {

	

}