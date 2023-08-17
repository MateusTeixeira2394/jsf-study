package br.com.devteixeira.bookstore.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.devteixeira.bookstore.config.db.ConnectionFactory;
import br.com.devteixeira.bookstore.entities.AuthorEntity;
import br.com.devteixeira.bookstore.entities.BookEntity;

public class BookDAO {
	
	private EntityManager em;
	
	public BookDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookstore");
		em = factory.createEntityManager();
	}
	
	public void create(BookEntity book) {
		
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
		
		
	}
	
	public List<BookEntity> getAll(){
		
		final String JPQL = "SELECT b FROM BookEntity b";

		return em.createQuery(JPQL, BookEntity.class).getResultList();
		
	}
	
}
