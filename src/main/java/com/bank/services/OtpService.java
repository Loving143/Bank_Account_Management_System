package com.bank.services;

import com.bank.entity.Otp;

public interface OtpService {

	boolean validateOtp(String username, String otpCode);

	Otp generateOtp(String username);

}
