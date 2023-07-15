package br.com.devteixeira.bookstore.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.devteixeira.bookstore.model.Book;

@ManagedBean
@RequestScoped
public class BookBean {

	private Book book;

	public BookBean() {
		super();
		book = new Book();
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void save() {

		System.out.println(book.getTitle());

	}

}
