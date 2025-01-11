package com.bank.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.dto.AdminDetailsDto;
import com.bank.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

	boolean existsByEmail(String email);

	boolean existsByPhoneNo(String phoneNo);

	boolean existsByPanCard(String panCard);

	boolean existsByAadhaarCard(String aadhaarCard);

	@Query("Select "
			+ "a.userName as name, "
			+ "a.password as password,"
			+ "a.email as email,"
			+ "a.phoneNo as phoneNo "
			+ "from Admin a "
			+ "where a.id =:id ")
	Optional<AdminDetailsDto> fetchAdminDetails(Integer id);

}
