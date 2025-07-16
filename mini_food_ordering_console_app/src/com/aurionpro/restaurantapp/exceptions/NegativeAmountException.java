package com.aurionpro.restaurantapp.exceptions;

public class NegativeAmountException extends Exception{

	int amount;

	public NegativeAmountException(int amount) {
		super();
		this.amount = amount;
	}
	
	public String getMessage()
	{
		return "Negative amount not allowed. You entered : "+amount;
	}
}
