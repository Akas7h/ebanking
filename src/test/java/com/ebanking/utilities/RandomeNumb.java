package com.ebanking.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomeNumb {

	public static String randomEmailString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return generatedString+"@gmail.com" ;
	}
	
	public static String randomPassword() {
		
		String randomPass = RandomStringUtils.randomNumeric(8);
		return randomPass+"5eR" ;
	}
	
	
	
}
