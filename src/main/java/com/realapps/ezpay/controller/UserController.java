package com.realapps.ezpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realapps.ezpay.dto.BankResponse;
import com.realapps.ezpay.dto.UserRequest;
import com.realapps.ezpay.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	
	
	@PostMapping
	public BankResponse createAccount(UserRequest userRequest) {
		System.out.println("This is the users name "+userRequest.getFirstName());
		return userService.createAccount(userRequest);
	}
	
}
