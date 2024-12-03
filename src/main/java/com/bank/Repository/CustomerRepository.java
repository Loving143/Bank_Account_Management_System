package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
