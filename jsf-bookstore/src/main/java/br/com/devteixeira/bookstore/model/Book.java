package br.com.devteixeira.bookstore.model;

import java.math.BigDecimal;

public class Book {

	private String title;
	private String type;
	private BigDecimal price;
	private String releaseDate;
	
	public Book() {
		super();
		title = "";
		type = "";
		price = new BigDecimal("0");
		releaseDate = "";
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	
}
