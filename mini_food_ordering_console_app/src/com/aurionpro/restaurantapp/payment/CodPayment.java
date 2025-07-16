package com.aurionpro.restaurantapp.payment;

import java.util.Scanner;

import com.aurionpro.restaurantapp.customer.Customer;

public class CodPayment implements IPayment{

	@Override
	public boolean pay(Scanner scanner, double amount, Customer customer) {
		System.out.println("Pay Rs."+amount+" to the delivery agent.");
		return true;
	}

	@Override
	public String getPaymentMode() {
		return "COD";
	}
	

}
