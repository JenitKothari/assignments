package com.aurionpro.restaurantapp.admin;

import java.util.Scanner;

import com.aurionpro.restaurantapp.customer.Customer;

public class CustomerLogin {
	
	public static Customer customerLogin(Scanner scanner)
	{
		System.out.println("Enter userId :");
		String userId = scanner.nextLine();
		if(!Utility.checkCustomerExists(userId))
		{
			System.out.println("User doesnt exists. Kindly signup.");
			return null;
		}
		System.out.println("Enter password :");
		String password = scanner.nextLine();
		return Utility.customerAuthentication(userId, password);
	}
	
	
}
