package br.com.devteixeira.bookstore.services;

import java.util.ArrayList;
import java.util.List;

import br.com.devteixeira.bookstore.daos.AuthorDAO;
import br.com.devteixeira.bookstore.entities.AuthorEntity;
import br.com.devteixeira.bookstore.models.Author;

public class AuthorService {

	AuthorDAO dao;

	public AuthorService() {
		dao = new AuthorDAO();
	}

	public void create(Author author) {

		AuthorEntity entity = new AuthorEntity();

		entity.setName(author.getName());

		dao.create(entity);

	}

	public List<Author> getAll() {

		List<Author> authors = new ArrayList<Author>();

		List<AuthorEntity> entityList = dao.getAll();

		for (AuthorEntity entity : entityList) {

			authors.add(new Author(entity.getName(), entity.getId()));

		}

		return authors;

	}
	
	public Author getById(Long id) {
		
		AuthorEntity entity = dao.getById(id);
		
		return new Author(entity.getName(), entity.getId());
		
	}

}
