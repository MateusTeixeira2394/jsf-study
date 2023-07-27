package br.com.devteixeira.bookstore.services;

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

}
