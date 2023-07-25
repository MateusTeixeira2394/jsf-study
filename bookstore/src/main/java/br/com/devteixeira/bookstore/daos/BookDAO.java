package br.com.devteixeira.bookstore.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.devteixeira.bookstore.config.db.ConnectionFactory;
import br.com.devteixeira.bookstore.entities.BookEntity;

public class BookDAO {
	
	private ConnectionFactory cf;
	
	public BookDAO() {
		cf = ConnectionFactory.getInstance();
	}
	
	public void create(BookEntity book) {
		
		cf.openConnection();
		cf.persist(book);
		cf.commit();
		cf.closeConnection();
		
	}
	
}
