package br.com.devteixeira.bookstore.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.devteixeira.bookstore.models.Book;

@ManagedBean
@RequestScoped
public class BookBean {

	private Book book;

	public BookBean() {
		book = new Book();
	}

	public void create() {
		System.out.println("Book " + book.getTitle() + " created");
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
