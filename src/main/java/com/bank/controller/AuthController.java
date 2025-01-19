package com.bank.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Repository.CustomerRepository;
import com.bank.entity.Admin;
import com.bank.entity.Customer;
import com.bank.entity.Otp;
import com.bank.fetch.factorydesignpattern.FetchRepositoryStrategyFactory;
import com.bank.security.auth.CustomUsernamePasswordAuthentication;
import com.bank.security.auth.EmailSending;
import com.bank.security.auth.FetchUserDetailsServiceFactory;
import com.bank.security.auth.LoginResponse;
import com.bank.security.auth.OtpRequest;
import com.bank.services.EntityFetchService;
import com.bank.services.JwtUtil;
import com.bank.services.OtpService;
	
@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private FetchUserDetailsServiceFactory userDetailsServiceFactory;

    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailSending email;
    
    @Autowired
    private JwtUtil jwtUtil;
    Admin admin=null;
    Customer customer = null;
    @Autowired
    private EntityFetchService entityFetchService;
    
    @PostMapping("/{userType}/login")
    public String login(@RequestBody  Object request, @PathVariable String userType) {
    	Map<String, Object> data = (Map<String, Object>) request;
    	Authentication authentication = authenticationManager.authenticate(
                new CustomUsernamePasswordAuthentication(
                (String)data.get("username"), (String)data.get("password"),userType));
      SecurityContextHolder.getContext().setAuthentication(authentication);
      Otp otp = otpService.generateOtp((String)data.get("username"));
      String emaill = null;
      String name = null;
    	  if ("admin".equals(userType)) {
    		  admin= (Admin)entityFetchService.getEntityByUsername(userType, (String)data.get("username"));
    		  emaill = admin.getEmail();
    		  name = admin.getUserName();
    	 } else if ("customer".equals(userType)) {
        	  customer = (Customer)entityFetchService.getEntityByUsername(userType, (String)data.get("username"));
        	  emaill = customer.getEmail();
        	  name = customer.getUserName();
         }else {
         throw new IllegalArgumentException("Invalid entityType: " + userType);
         }
    	  Map<String, Object> model = new HashMap<>();
          model.put("name",name);
          model.put("email", emaill);
          model.put("subscription", "Premium");
          model.put("otp",otp.getOtpCode());
          model.put("bankName","SBI Bank");
      email.sendEmail(emaill, "Your otp for login to SBI Bank is : "
    		  +otp.getOtpCode() +".Please do not share it with any one.","OTP Verification",model);
      return "OTP generated successfully: "+otp.getOtpCode();
    }
    @PostMapping("/{userType}/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody OtpRequest otpReq,@PathVariable String userType) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(otpReq.getUsername(), otpReq.getOtp()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsService userDetailsService=  userDetailsServiceFactory.fetchUserDetailsService(userType);
        UserDetails user =  userDetailsService.loadUserByUsername(otpReq.getUsername());
        String jwtToken = jwtUtil.generateToken(otpReq.getUsername());
        LoginResponse response = new LoginResponse(jwtToken,user);
        return ResponseEntity.ok(response);
    }
    
    
}
