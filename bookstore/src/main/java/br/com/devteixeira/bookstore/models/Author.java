package br.com.devteixeira.bookstore.models;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private String name;
	private long id;
	private List<Book> books;

	public Author() {
		name = "";
		id = 0;
		books = new ArrayList<Book>();
	}
	
	public Author(String name, long id) {
		this.name = name;
		this.id = id;
		books = new ArrayList<Book>();
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
