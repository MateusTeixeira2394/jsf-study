package br.com.devteixeira.bookstore.models;

import java.math.BigDecimal;

public class Book {
	
	private String title;
	private String type;
	private String date;
	private BigDecimal price;
	
	public Book() {
		title = "";
		type = "";
		price = new BigDecimal("0");
		date = "";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
}
