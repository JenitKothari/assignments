package com.aurionpro.model;

import java.util.Scanner;

import com.aurionpro.exception.NegativeAmountException;
import com.aurionpro.exception.OverdraftLimitReachedException;

public class CurrentAccount extends AccountBasic{
	private int overdraftLimit;
	
	public CurrentAccount()
	{}

	public CurrentAccount(String name, int balance, AccountType accountType, int overdraftLimit) {
		super(name, balance, accountType);
		this.overdraftLimit = overdraftLimit;
	}

	public int getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(int overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	public void credit(int amount)
	{
		try {
			if(amount<0)
			{
				throw new NegativeAmountException(amount);
			}
			int balance = getBalance();
			balance += amount;
			setBalance(balance);
			System.out.println("Rs."+amount+" deposited successfully.");
			
		}
		catch(NegativeAmountException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void debit(int amount)
	{
		Scanner scanner = new Scanner(System.in);
		
		try {
			if(amount<0)
			{
				throw new NegativeAmountException(amount);
			}
			
			int balance = getBalance();
			
			try{
				balance -= amount;
				if(balance<0)
				{
					System.out.println("Insufficient Balance.");
					System.out.println("Do you want to use Overdraft?");
					System.out.println("1 = yes\n2 = no");
					int choice = scanner.nextInt();
					if(choice==1)
					{
						int overdraft = getOverdraftLimit();
						//overdraft+=balance;
						if(overdraft+balance<0)
						{
							int excessAmount = overdraft+balance;
							throw new OverdraftLimitReachedException(overdraft, excessAmount );
						}
						setOverdraftLimit(overdraft);
						setBalance(0);
						System.out.println("Rs."+amount+" withdrawn successfully.");
					}
					return;
				}
				setBalance(balance);
				System.out.println("Rs."+amount+" withdrawn successfully.");
			}
			catch(OverdraftLimitReachedException exception)
			{
				System.out.println(exception.getMessage());
			}
		}
		catch(NegativeAmountException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void display()
	{
		System.out.println("Account Details:");
		System.out.println("Name : "+getName());
		System.out.println("Account Number : "+getAccountNumber());
		System.out.println("Account type : Current");
		System.out.println("Overdraft Limit : Rs."+overdraftLimit);
		System.out.println("Balance : Rs."+getBalance());
	}
	
}
