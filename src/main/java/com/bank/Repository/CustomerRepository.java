package com.bank.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.dto.CustomerDetailsDto;
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
	
	@Query(" Select "
			+ " c.userName as name,"
			+ " c.password as password "
			+ " from Customer c "
			+ " where c.id=:id "
			)
	public Optional<CustomerDetailsDto> fetchCustomerDetails(Integer id);

	boolean existsByEmailAndIdNot(String email,Integer id);

	boolean existsByPhoneNoAndIdNot(String phoneNo,Integer id);

	boolean existsByPanCardAndIdNot(String panCard,Integer id);

	boolean existsByAadhaarCardAndIdNot(String aadhaarCard,Integer id);

	Optional<Customer> findByUserName(String username);

}
