package com.realapps.ezpay.utils;

import java.time.Year;

public class AccountUtils {
	
	public final static String ACCOUNT_EXIST_CODE ="001";
	public final static String ACCOUNT_EXIST_MESSAGE ="This user already has an account created";
	public final static String ACCOUNT_CREATION_CODE ="002";
	public final static String ACCOUNT_CREATION_MESSAGE ="Congratulations your account was successfully created";
	
	public static String generateAccountNumber() {
		
		Year currentYear = Year.now();
		int min = 100000;
		int max= 999999;
		
		int randomNum = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		String year=String.valueOf(currentYear);
		String num=String.valueOf(randomNum);
		return year+num;
	}

}
