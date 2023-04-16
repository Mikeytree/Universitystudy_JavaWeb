package com.model;

public class ShoppingCart {
	private String username ;
	private int id;
	private String pname;
	private float price;
	private int quantity;
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(String username, int id, String pname, float price, int quantity) {
		super();
		this.username = username;
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
