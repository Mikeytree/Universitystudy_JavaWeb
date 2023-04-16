package com.model;

public class Products {
	private int id;
	 private String pname;
	 private String brand;
	 private float price;
	 private int stock;
	 public Products() {
			super();
		}
	public Products(int id, String pname, String brand, float price, int stock) {
		super();
		this.id = id;
		this.pname = pname;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	 
}
