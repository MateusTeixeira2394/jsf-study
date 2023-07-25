package br.com.devteixeira.bookstore.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.devteixeira.bookstore.daos.BookDAO;
import br.com.devteixeira.bookstore.entities.BookEntity;
import br.com.devteixeira.bookstore.models.Book;

public class BookService {

	private BookDAO dao;
	
	private SimpleDateFormat dateFormat;
	
	public BookService() {
		
		dao = new BookDAO();
		
		final String pattern = "dd/MM/yyyy";		
		dateFormat = new SimpleDateFormat(pattern);
		
	}
	
	public void create(Book book) {
		
		BookEntity entity = new BookEntity();
		
		try {
			
			entity.setTitle(book.getTitle());
			entity.setType(book.getType());
			entity.setDate(dateFormat.parse(book.getDate()));
			entity.setPrice(book.getPrice());
			
			dao.create(entity);
			
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		
	}
	
}
