package com.aurionpro.restaurantapp.payment;

import java.util.Scanner;

import com.aurionpro.restaurantapp.customer.Customer;

public class UpiPayment implements IPayment{

	@Override
	public boolean pay(Scanner scanner, double amount, Customer customer) {
		scanner.nextLine();
		System.out.println("Pay Rs."+amount+" using UPI.");
		System.out.println("Enter upi id:");
		String upiId = scanner.nextLine();
		System.out.println("Enter pin:");
		String pin = scanner.nextLine();
		
		if(customer.getUpiId().equals(upiId) && customer.getPin().equals(pin))
		{
			System.out.println("Payment successful!");
			return true;
		}
		System.out.println("Incorrect credentials");
		return false;
	}

	@Override
	public String getPaymentMode() {
		return "UPI";
	}

}
