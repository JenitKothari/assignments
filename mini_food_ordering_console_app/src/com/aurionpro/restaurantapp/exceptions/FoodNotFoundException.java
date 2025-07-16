package com.aurionpro.restaurantapp.exceptions;

public class FoodNotFoundException extends Exception{

	int foodId;

	public FoodNotFoundException(int foodId) {
		super();
		this.foodId = foodId;
	}
	
	public String getMessage()
	{
		return "Food ID : "+foodId+" not present";
	}
}
