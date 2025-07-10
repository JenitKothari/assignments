package com.aurionpro.exception;

public class NegativeAmountException extends RuntimeException{
	private int amount;

	public NegativeAmountException(int amount) {
		super();
		this.amount = amount;
	}
	
	public String getMessage()
	{
		return "Amount cant be negative";
	}
}
