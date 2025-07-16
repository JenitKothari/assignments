package com.aurionpro.restaurantapp.deliveryagent;

public class DeliveryAgent {

	private static int index = 0;
	private int agentId;
	private String agentName;
	private String mobileNumber;
	private boolean isFree;
	private int orderId;
	
	public DeliveryAgent(String agentName, String mobileNumber) {
		this.agentId=index++;
		this.agentName=agentName;
		this.mobileNumber = mobileNumber;
		isFree = true;
	}

	public String getAgentName() {
		return agentName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "agentId = " + agentId + "\nagentName = " + agentName + "\nmobileNumber = " + mobileNumber;
	}
	
	
}
