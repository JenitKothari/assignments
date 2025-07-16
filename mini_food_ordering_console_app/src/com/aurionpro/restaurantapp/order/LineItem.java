package com.aurionpro.restaurantapp.order;

import com.aurionpro.restaurantapp.food.Food;

public class LineItem {

	private Food food;
	private int quantity;
	private double total;
	
	public LineItem(Food food, int qunatity) {
		this.food = food;
		this.quantity = qunatity;
		this.total = food.getPrice()*quantity;
	}

	public Food getFood() {
		return food;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotal(double total) {
		this.total = total;
	}	
	
}
