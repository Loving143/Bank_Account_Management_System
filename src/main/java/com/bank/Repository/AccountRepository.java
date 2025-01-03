package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	boolean existsByAccountNumber(String accountNumber);

}
