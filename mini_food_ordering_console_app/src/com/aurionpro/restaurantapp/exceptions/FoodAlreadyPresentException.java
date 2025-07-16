package com.aurionpro.restaurantapp.exceptions;

public class FoodAlreadyPresentException extends Exception{

	String foodName;

	public FoodAlreadyPresentException(String foodName) {
		super();
		this.foodName = foodName;
	}
	
	public String getMessage()
	{
		return "Food : "+foodName+" already present";
	}
}
