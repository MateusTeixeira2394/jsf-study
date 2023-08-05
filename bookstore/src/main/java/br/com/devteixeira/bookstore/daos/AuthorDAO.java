package br.com.devteixeira.bookstore.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.devteixeira.bookstore.entities.AuthorEntity;
import br.com.devteixeira.bookstore.models.Author;

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

	public List<AuthorEntity> getAll() {

		final String JPQL = "SELECT a FROM AuthorEntity a";

		return em.createQuery(JPQL, AuthorEntity.class).getResultList();

	}

	public AuthorEntity getById(Long id) {

		return em.find(AuthorEntity.class, id);

	}

}
