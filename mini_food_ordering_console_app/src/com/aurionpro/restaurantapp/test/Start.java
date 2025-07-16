package com.aurionpro.restaurantapp.test;

import java.util.Scanner;

import com.aurionpro.restaurantapp.admin.Admin;
import com.aurionpro.restaurantapp.admin.AdminLogin;
import com.aurionpro.restaurantapp.admin.CustomerLogin;
import com.aurionpro.restaurantapp.admin.CustomerSignUp;
import com.aurionpro.restaurantapp.customer.Customer;

public class Start {

	public void start() throws InterruptedException
	{
		Scanner scanner = new Scanner(System.in);
		
		Admin admin = new Admin();
		System.out.println("Welcome to AMAR Restaurant");
		int choice = 0;
		while(choice!=3)
		{
			System.out.println("1 = Admin\n2 = Customer\n3 = Exit");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				if(AdminLogin.adminLogin(scanner))
				{
					System.out.println("Admin login successful.");
					AdminMenu.menu(scanner,admin);
					continue;
				}
				System.out.println("Incorrect credentials.");
				break;
			case 2:
				customerLoginChoice(scanner);
				break;
			case 3:
				System.out.println("Exiting...");
				Thread.sleep(2000);
				System.out.println("Thank you.");
				break;
			default:
				System.out.println("Invalid choice");
			}
			
		}
	}

	private void customerLoginChoice(Scanner scanner) {
		System.out.println("1 = Login\n2 = SignUp");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice)
		{
		case 1:
			Customer customer = CustomerLogin.customerLogin(scanner);
			if(customer!=null)
			{
				System.out.println("Customer Login successful");
				CustomerMenu.menu(scanner,customer);
			}
			break;
		case 2:
			CustomerSignUp.signup(scanner);
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
}
