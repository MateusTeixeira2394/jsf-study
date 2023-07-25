package br.com.devteixeira.bookstore.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.devteixeira.bookstore.models.Book;
import br.com.devteixeira.bookstore.services.BookService;

@ManagedBean
@RequestScoped
public class BookBean {

	private Book book;
	
	private BookService service;

	public BookBean() {
		book = new Book();
		service = new BookService();
	}

	public void create() {
		
		try {
			
			service.create(book);
			
		} catch (RuntimeException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
