package com.aurionpro.restaurantapp.admin;

import java.util.Scanner;

import com.aurionpro.restaurantapp.customer.Customer;

public class CustomerSignUp {
	public static void signup(Scanner scanner)
	{
		System.out.println("Enter name:");
		String name = scanner.nextLine();
		System.out.println("Enter mobile number:");
		String mobileNumber = scanner.nextLine();
		System.out.println("Enter Address:");
		String address = scanner.nextLine();
		System.out.println("Enter User Id:");
		String userId = scanner.nextLine();
		System.out.println("Enter password:");
		String password = scanner.nextLine();
		
		if(Utility.checkCustomerExists(userId))
		{
			System.out.println("User already exists.");
			return;
		}
		Admin.getCustomers().add(new Customer(name,address,mobileNumber,userId,password));
	}
}
