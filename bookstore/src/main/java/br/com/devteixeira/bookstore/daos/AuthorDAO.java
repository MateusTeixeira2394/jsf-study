package br.com.devteixeira.bookstore.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.devteixeira.bookstore.entities.AuthorEntity;

public class AuthorDAO {
	
	private EntityManager em;
	
	public AuthorDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookstore");
		em = factory.createEntityManager();
	}

	public void create(AuthorEntity author) {
		
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
		em.close();
		
	}

}
