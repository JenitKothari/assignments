package com.aurionpro.model;

import com.aurionpro.exception.MinimumBalanceException;
import com.aurionpro.exception.NegativeAmountException;

public class SavingsAccount extends AccountBasic{
	private int minimumBalance;
	
	public SavingsAccount()
	{}

	public SavingsAccount(String name, int balance, AccountType accountType, int minimumBalance) {
		super(name, balance, accountType);
		this.minimumBalance = minimumBalance;
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
		try {
			if(amount<0)
			{
				throw new NegativeAmountException(amount);
			}
			int balance = getBalance();
			balance -= amount;
//			if(balance<0)
//			{
//				System.out.println("Insufficient Balance.");
//				return;
//			}
			try {
				if(balance<minimumBalance)
				{
					//setBalance(balance);
					//System.out.println("Balance is less than Minimum Balance.");
//					System.out.println("Rs."+amount+" withdrawn successfully.");
					throw new MinimumBalanceException(balance);
				}
				setBalance(balance);
				System.out.println("Rs."+amount+" withdrawn successfully.");
			}
			catch(MinimumBalanceException exception)
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
		System.out.println("Account type : Savings");
		System.out.println("Minimum Balance : Rs."+minimumBalance);
		System.out.println("Balance : Rs."+getBalance());
	}
}
