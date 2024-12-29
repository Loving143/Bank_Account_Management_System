package com.bank.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.entity.Address;
import com.bank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{


	@Query(" Select address from Customer c "
			+ " inner join c.addresses address "
			+ " where c.id = :customerId")
	List<Address> addRessHistoryByCustomerId(Integer customerId);

	@Query(" Select address from Customer c "
			+ " inner join c.addresses address on address.addressType = com.bank.enumm.AddressType.CURRENT_ADDRESS "
			+ " where c.id = :customerId")
	List<Address> currentAddRessHistoryByCustomerId(Integer customerId);

	@Query(" Select address from Customer c "
			+ " inner join c.addresses address on address.addressType = com.bank.enumm.AddressType.PERMANENT_ADDRESS "
			+ " where c.id = :customerId")
	List<Address> permanentAddressHistoryByCustomerId(Integer customerId);

	boolean existsByEmail(String email);

	boolean existsByPhoneNo(String phoneNo);

	boolean existsByPanCard(String panCard);

	boolean existsByAadhaarCard(String aadhaarCard);

}
