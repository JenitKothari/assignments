package com.aurionpro.exception;

public class OverdraftLimitReachedException extends RuntimeException {

	private int overdraftLimit;
	private int amount;
	public OverdraftLimitReachedException(int overdraftLimit, int amount) {
		super();
		this.overdraftLimit = overdraftLimit;
		this.amount = amount;
	}
	
	public String getMessage()
	{
		return "OverdraftLimit Reached.";
	}
}
