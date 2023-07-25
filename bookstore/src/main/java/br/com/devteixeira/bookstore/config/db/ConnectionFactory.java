package br.com.devteixeira.bookstore.config.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static ConnectionFactory instance;

	private EntityManager entityManager;

	private ConnectionFactory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookstore");
		entityManager = factory.createEntityManager();
	}

	public static ConnectionFactory getInstance() {

		if (instance == null) {
			instance = new ConnectionFactory();
		}

		return instance;

	}

	public void openConnection(){
		entityManager.getTransaction().begin();
	}

	public <T> void persist(T entity) {
		
		entityManager.persist(entity);
		
	}
	
	public void commit() {
		entityManager.getTransaction().commit();
	}
	
	public void closeConnection() {
		entityManager.close();
	}

}
