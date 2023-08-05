package br.com.devteixeira.bookstore.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Book {
	
	private String title;
	private String type;
	private String date;
	private BigDecimal price;
	private List<Author> authors;
	
	public Book() {
		title = "";
		type = "";
		price = new BigDecimal("0");
		date = "";
		authors = new ArrayList<Author>();
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
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
