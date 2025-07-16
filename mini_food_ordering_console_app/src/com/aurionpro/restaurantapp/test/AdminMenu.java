package com.aurionpro.restaurantapp.test;

import java.util.Scanner;

import com.aurionpro.restaurantapp.admin.Admin;

public class AdminMenu {

	public  static void menu(Scanner scanner, Admin admin)
	{
		int choice = 0;
		while(choice!=8)
		{
			displayMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				admin.addFood(scanner);
				break;
			case 2:
				admin.removeFood(scanner);
				break;
			case 3:
				admin.displayMenu(scanner);
				break;
			case 4:
				admin.viewOrders();
				break;
			case 5:
				admin.showAllDeliveryAgent();
				break;
			case 6:
				admin.addDeliveryAgent(scanner);
				break;
			case 7:
				admin.removeDeliveryAgent(scanner);
				break;
			case 8:
				System.out.println("Logged out.");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	private static void displayMenu() {
		System.out.println();
		System.out.println("**********Admin Panel**********");
		System.out.println("1 = Add new food");
		System.out.println("2 = Remove food");	
		System.out.println("3 = Display menu");	
		System.out.println("4 = View all orders");	
		System.out.println("5 = Show all delivery agents");
		System.out.println("6 = Add new delivery agent");	
		System.out.println("7 = Remove delivery agent");
		System.out.println("8 = Logout");
	}
}
