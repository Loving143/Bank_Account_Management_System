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
	
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJSYW5pIiwiaWF0IjoxNzM3Mjg5MTkxLCJleHAiOjE3Mzc2NDkxOTF9.VHf2bYDn2l8k9eHlPVxlsRr9dQqAfGpS60MNiRkWQog";  // Replace with your actual JWT token
        String secretKey = "ZGe7eDBd1lSvPy8peQZjISBZIc/x40SBwlS5omD7Hlk=";  // Replace with your secret key

        try {
            // Parse the token
            Claims claims = Jwts.parser()
                                .setSigningKey(secretKey) // Set the signing key
                                .parseClaimsJws(token)
                                .getBody();

            // Extract the roles
            List<String> roles = claims.get("roles", List.class);

            System.out.println("Roles: " + roles);
        } catch (Exception e) {
            System.out.println("Invalid token: " + e.getMessage());
        }
	}
}
