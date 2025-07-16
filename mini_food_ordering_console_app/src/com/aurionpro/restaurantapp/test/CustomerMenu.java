package com.aurionpro.restaurantapp.test;

import java.util.Scanner;

import com.aurionpro.restaurantapp.customer.Customer;

public class CustomerMenu {

	public static void menu(Scanner scanner, Customer customer)
	{
		int choice = 0;
		while(choice!=4)
		{
			displayMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				customer.displayMenu(scanner);
				break;
			case 2:
				customer.placeNewOrder(scanner);
				break;
			case 3:
				customer.showOrderHistory();
				break;
			case 4:
				System.out.println("Logged out.");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	private static void displayMenu() {
		System.out.println();
		System.out.println("**********Customer Panel**********");	
		System.out.println("1 = Display menu");
		System.out.println("2 = Place new order");
		System.out.println("3 = Order history");
		System.out.println("4 = Logout");
	}
}
