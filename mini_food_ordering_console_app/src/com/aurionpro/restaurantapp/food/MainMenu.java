package com.aurionpro.restaurantapp.food;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {

	public static Map<String,Menu> mainMenu = new HashMap<>();
	
	public MainMenu() {
		mainMenu.put("Indian",new Menu("Indian"));
		mainMenu.put("Italian",new Menu("Italian"));
		mainMenu.put("Mexican",new Menu("Mexican"));
		
		Menu indianMenu = mainMenu.get("Indian");
		indianMenu.getItems().add(new Food("Paneer Tikka", 120, "Grilled paneer", "Indian"));
		indianMenu.getItems().add(new Food("Masala Dosa", 90, "Crispy dosa", "Indian"));
		indianMenu.getItems().add(new Food("Chole Bhature", 100, "Spicy chole", "Indian"));
		indianMenu.getItems().add(new Food("Rajma Chawal", 80, "Beans with rice", "Indian"));
		indianMenu.getItems().add(new Food("Veg Biryani", 110, "Aromatic rice", "Indian"));
		
		Menu italianMenu = mainMenu.get("Italian");
		italianMenu.getItems().add(new Food("Margherita Pizza", 250, "Cheese pizza", "Italian"));
		italianMenu.getItems().add(new Food("Pasta Alfredo", 200, "White sauce pasta", "Italian"));
		italianMenu.getItems().add(new Food("Bruschetta", 120, "Toasted bread", "Italian"));
		italianMenu.getItems().add(new Food("Risotto", 220, "Creamy rice", "Italian"));
		italianMenu.getItems().add(new Food("Lasagna", 270, "Layered pasta", "Italian"));
		

		Menu mexicanMenu = mainMenu.get("Mexican");
		mexicanMenu.getItems().add(new Food("Veg Tacos", 100, "Corn tortilla", "Mexican"));
		mexicanMenu.getItems().add(new Food("Nachos", 150, "Chips with cheese", "Mexican"));
		mexicanMenu.getItems().add(new Food("Veg Burrito", 200, "Stuffed wrap", "Mexican"));
		mexicanMenu.getItems().add(new Food("Quesadilla", 180, "Cheese tortilla", "Mexican"));
		mexicanMenu.getItems().add(new Food("Churros", 120, "Fried pastry", "Mexican"));
	}
	
	public void displayMenu(Scanner scanner)
	{
		System.out.println("select cuisine");
		System.out.println("1 = Indian\n2 = Italian\n3 = Mexican");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice)
		{
		case 1:
			mainMenu.get("Indian").displayMenu();;
			break;
		case 2:
			mainMenu.get("Italian").displayMenu();
			break;
		case 3:
			mainMenu.get("Mexican").displayMenu();
			break;
		default:
			System.out.println("Invalid choice");
		}
	}

	public void addFood(Scanner scanner)
	{		
		System.out.println("select cuisine");
		System.out.println("1 = Indian\n2 = Italian\n3 = Mexican");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice)
		{
		case 1:
			mainMenu.get("Indian").addFood(scanner,"Indian");
			break;
		case 2:
			mainMenu.get("Italian").addFood(scanner,"Italian");
			break;
		case 3:
			mainMenu.get("Mexican").addFood(scanner,"Mexican");
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
	
	public void deleteFood(Scanner scanner)
	{		
		System.out.println("select cuisine");
		System.out.println("1 = Indian\n2 = Italian\n3 = Mexican");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice)
		{
		case 1:
			mainMenu.get("Indian").removeFood(scanner);
			break;
		case 2:
			mainMenu.get("Italian").removeFood(scanner);
			break;
		case 3:
			mainMenu.get("Mexican").removeFood(scanner);
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
	
	public static boolean checkFoodExistsByName(String foodName, String cuisine)
	{
		Menu menu = mainMenu.get(cuisine);
		for(Food food : menu.getItems())
		{
			if(food.getFoodName().equalsIgnoreCase(foodName))
				return true;
		}
		return false;
	}
	
	public static Food checkFoodExistsById(int foodId)
	{
		
		for(Menu menu : mainMenu.values())
		{
			for(Food food : menu.getItems())
			{
				if(food.getFoodId()==foodId)
					return food;
			}
		}
		return null;
	}
}
