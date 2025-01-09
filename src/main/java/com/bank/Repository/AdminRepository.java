package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

	boolean existsByEmail(String email);

	boolean existsByPhoneNo(String phoneNo);

	boolean existsByPanCard(String panCard);

	boolean existsByAadhaarCard(String aadhaarCard);

}
