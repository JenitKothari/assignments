package com.aurionpro.restaurantapp.food;

public class Food {
	private static int index = 0;
	private int foodId;
	private String foodName;
	private double price;
	private String description;
	private String cuisine;

	public Food() {
	}

	public Food(String foodName, double price, String description, String cuisine) {
		super();
		this.foodId = index;
		index++;
		this.foodName = foodName;
		this.price = price;
		this.description = description;
		this.cuisine = cuisine;
	}

	public static int getIndex() {
		return index;
	}

	public int getFoodId() {
		return foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getCuisine() {
		return cuisine;
	}

	public static void setIndex(int index) {
		Food.index = index;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCusine(String cuisine) {
		this.cuisine = cuisine;
	}

}
