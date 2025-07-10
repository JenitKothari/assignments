package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.AccountType;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingsAccount;

public class TestAccountBasic {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome, create an account.");
		System.out.println("Enter Name :");
		String name = scanner.next();
		System.out.println("Enter initial balance :");
		int balance = scanner.nextInt();
		System.out.println("Enter Account Type (Savings=1/Current=2):");
		int accountTypeChoice = scanner.nextInt();
	
		if(accountTypeChoice==1)
		{
			System.out.println("Enter minimum balance: (10000/15000/20000)");
			int minimumBalance = scanner.nextInt();
			SavingsAccount savingsAccount = new SavingsAccount(name,balance,AccountType.Savings,minimumBalance);
			savingsAccountMenu(savingsAccount, scanner);
		}
		else
		{
			System.out.println("Enter over draft limit: (10000,25000,50000)");
			int overdraftLimit = scanner.nextInt();
			CurrentAccount currentAccount = new CurrentAccount(name,balance,AccountType.Current,overdraftLimit);
			currentAccountMenu(currentAccount, scanner);
		}
	}
	
	public static void savingsAccountMenu(SavingsAccount savingsAccount, Scanner scanner)
	{
		int choice=0;
		while(choice!=5)
		{
			System.out.println("Menu:");
			System.out.println("1. View Account Details\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Exit");
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1:
					savingsAccount.display();
					break;
				case 2:
					System.out.println("Enter the amount to be deposited.");
					int depositeAmount = scanner.nextInt();
					savingsAccount.credit(depositeAmount );
					break;
				case 3:
					System.out.println("Enter the amount to be withdrawn.");
					int withdrawAmount = scanner.nextInt();
					savingsAccount.debit(withdrawAmount);
					break;
				case 4:
					savingsAccount.viewBalance();
					break;
				case 5:
					System.out.println("Exited successfully");
					break;
				default:
					System.out.println("Enter valid choice.");
					
			}
			System.out.println();
		}
	}
	
	public static void currentAccountMenu(CurrentAccount currentAccount, Scanner scanner)
	{
		int choice=0;
		while(choice!=5)
		{
			System.out.println("Menu:");
			System.out.println("1. View Account Details\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Exit");
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1:
					currentAccount.display();
					break;
				case 2:
					System.out.println("Enter the amount to be deposited.");
					int depositeAmount = scanner.nextInt();
					currentAccount.credit(depositeAmount );
					break;
				case 3:
					System.out.println("Enter the amount to be withdrawn.");
					int withdrawAmount = scanner.nextInt();
					currentAccount.debit(withdrawAmount);
					break;
				case 4:
					currentAccount.viewBalance();
					break;
				case 5:
					System.out.println("Exited successfully");
					break;
				default:
					System.out.println("Enter valid choice.");
					
			}
			System.out.println();
		}
	}

}
