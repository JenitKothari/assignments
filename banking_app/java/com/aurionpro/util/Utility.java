package com.aurionpro.util;

public class Utility {

	private static int counter;
	
	public Utility() {
		
	}
	
	public static String getAccountNumber()
	{
		String accountNumber = "SBIN000";
		accountNumber += counter;
		counter++;
		return accountNumber;
	}
}
