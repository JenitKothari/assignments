package com.aurionpro.restaurantapp.exceptions;

public class DeliveryAgentNotExistsException extends Exception{

	int id;
	
	public DeliveryAgentNotExistsException(int id) {
		super();
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "Delivery Agent with id : "+id+" doesnt exists";
	}
}
