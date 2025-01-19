package com.bank;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
@SpringBootApplication
public class BankAccountManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountManagementSystemApplication.class, args);
	
	}
}
