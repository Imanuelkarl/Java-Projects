package com.realapps.ezpay.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realapps.ezpay.dto.AccountInfo;
import com.realapps.ezpay.dto.BankResponse;
import com.realapps.ezpay.dto.UserRequest;
import com.realapps.ezpay.entity.User;
import com.realapps.ezpay.repository.UserRepository;
import com.realapps.ezpay.utils.AccountUtils;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	@Override
	public BankResponse createAccount(UserRequest userRequest) {
		// TODO Auto-generated method stub
		//System.out.print(userRequest.getFirstName());
		
		if(userRepository.existsByEmail(userRequest.getEmail())) {
			if(userRequest.getEmail()==null) {
				return BankResponse.builder()
						.responseCode("003")
						.responseMessage("Users email is null the email must not be null")
						.info(null)
						.build();
			}
			return BankResponse.builder()
					.responseCode(AccountUtils.ACCOUNT_EXIST_CODE)
					.responseMessage(AccountUtils.ACCOUNT_EXIST_MESSAGE)
					.info(null)
					.build();
			
			
		}
		User newUser = User.builder()
				.firstName(userRequest.getFirstName())
				.lastName(userRequest.getLastName())
				.otherName(userRequest.getOtherName())
				.gender(userRequest.getGender())
				.address(userRequest.getAddress())
				.stateOfOrigin(userRequest.getStateOfOrigin())
				.accountNumber(AccountUtils.generateAccountNumber())
				.accountBalance(BigDecimal.ZERO)
				.email(userRequest.getEmail())
				.phoneNumber(userRequest.getPhoneNumber())
				.status("Active")
				.build();
		
		User savedUser = userRepository.save(newUser);
		
		return BankResponse.builder()
				.responseCode(AccountUtils.ACCOUNT_CREATION_CODE)
				.responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
				.info(AccountInfo.builder()
						.accountName(savedUser.getFirstName()+" "+savedUser.getOtherName()+" "+savedUser.getLastName())
						.accountBalance(savedUser.getAccountBalance())
						.accountNumber(savedUser.getAccountNumber())
						.build())
				.build();
	}

}
