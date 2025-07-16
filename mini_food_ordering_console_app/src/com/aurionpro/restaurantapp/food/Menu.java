package com.aurionpro.restaurantapp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.restaurantapp.exceptions.FoodAlreadyPresentException;
import com.aurionpro.restaurantapp.exceptions.FoodNotFoundException;

public class Menu {

	private String cuisine;
	private List<Food> items = new ArrayList<>();
	
	public Menu(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getCuisine() {
		return cuisine;
	}

	public List<Food> getItems() {
		return items;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public void setItems(List<Food> items) {
		this.items = items;
	}
	
	public void displayMenu() {
		System.out.printf("%-5s | %-20s | %-8s | %-20s | %-10s%n", "ID", "Food Name", "Price", "Description",
				"Cuisine");
		System.out.println("----------------------------------------------------------------------");

		for (Food food : items) {
			System.out.printf("%-5d | %-20s | ₹%-7.2f | %-20s | %-10s%n", food.getFoodId(), food.getFoodName(),
					food.getPrice(), food.getDescription(), food.getCuisine());
		}

	}
	
	public void addFood(Scanner scanner, String cuisine) {
		System.out.println("Enter food name:");
		String foodName = scanner.nextLine();
		System.out.println("Enter price:");
		double price=0;
		try {
			price = scanner.nextDouble();
		}catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		scanner.nextLine();
		System.out.println("Enter description");
		String description = scanner.nextLine();
		try {
			if(MainMenu.checkFoodExistsByName(foodName,cuisine))
			{
				throw new FoodAlreadyPresentException(foodName);
			}
			items.add(new Food(foodName,price, description, cuisine));
			System.out.println("Item : "+foodName+" added successfully.");
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void removeFood(Scanner scanner) {
		System.out.println("Enter Food Id to be removed:");
		int foodId = scanner.nextInt();
		Food food = null;
		try {
			food = MainMenu.checkFoodExistsById(foodId);
			if(food==null)
				throw new FoodNotFoundException(foodId);
			items.remove(food);
			System.out.println("Food Id : "+foodId+" removed successfully.");
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}

}
