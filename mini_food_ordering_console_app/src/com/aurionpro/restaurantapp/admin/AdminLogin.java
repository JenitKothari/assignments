package com.aurionpro.restaurantapp.admin;

import java.util.Scanner;

public class AdminLogin {

	public static boolean adminLogin(Scanner scanner)
	{
		System.out.println("Enter Admin Id:");
		String adminId = scanner.nextLine();
		System.out.println("Enter Password:");
		String adminPassword = scanner.nextLine();
		if(Admin.getAdminId().equals(adminId) && Admin.getPassword().equals(adminPassword))
		{
			return true;
		}
		return false;
	}
}
