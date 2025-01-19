package com.bank.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Otp;

public interface OtpRepository extends JpaRepository<Otp,Integer> {

	Optional<Otp> findByUsernameAndOtpCode(String username, String otpCode);

}
