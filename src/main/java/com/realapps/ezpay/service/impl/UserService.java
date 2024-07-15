package com.realapps.ezpay.service.impl;

import com.realapps.ezpay.dto.BankResponse;
import com.realapps.ezpay.dto.UserRequest;

public interface UserService {
	BankResponse createAccount(UserRequest userRequest);
}
