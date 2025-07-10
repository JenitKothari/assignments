package com.aurionpro.basics.controlstructures;
import java.util.Random;
import java.util.Scanner;

public class PigGameCodeCalisthenics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int turns = 5;
		int sum = 0;
		int number = 20;
	
		for(int i=0; i<turns && sum<20; i++)
		{
			int turnSum = 0;
			System.out.printf("Turn %d:\n",i+1);
			turnSum=playTurn();
			sum+=turnSum;
			System.out.printf("Turn %d score : %d\n",i+1,turnSum);
		}
		if(sum<20)
		{
			System.out.println("You Loose.");
			return;
		}
		System.out.println("You Win");
	}
	
	private static int playTurn()
	{
		Scanner scanner = new Scanner(System.in);
		char choice = 'r';
		int turnSum = 0;
		while(choice!='h' && turnSum!=-1)
		{
			System.out.println("Roll or Hold (r/h):");
			choice = scanner.next().charAt(0);
			turnSum += rollOrHold(choice, turnSum);
		}
		if(turnSum == -1)
			return 0;
		return turnSum;
	}
	
	private static int rollOrHold(char choice, int turnSum)
	{
		Random random = new Random();
		if(choice == 'h')
		{
			return 0;
		}
		int point = random.nextInt(6)+1;
		System.out.println("Die : "+point);
		if(point==1)
		{
			System.out.println("Turn Over.");
			return -(turnSum+1);
		}
		return point;
	}
}