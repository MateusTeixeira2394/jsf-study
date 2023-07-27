package br.com.devteixeira.bookstore.beans;

import br.com.devteixeira.bookstore.models.Author;
import br.com.devteixeira.bookstore.services.AuthorService;

public class AuthorBean {

	private Author author;

	private AuthorService service;

	public AuthorBean() {
		author = new Author();
		service = new AuthorService();
	}

	public void create() {
		
		try {

			service.create(author);

		} catch (RuntimeException e) {

			System.out.println(e.getMessage());

		}
		
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
