package br.com.devteixeira.bookstore.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.devteixeira.bookstore.daos.BookDAO;
import br.com.devteixeira.bookstore.entities.AuthorEntity;
import br.com.devteixeira.bookstore.entities.BookEntity;
import br.com.devteixeira.bookstore.models.Author;
import br.com.devteixeira.bookstore.models.Book;

public class BookService {

	private BookDAO dao;

	private SimpleDateFormat dateFormat;

	private final String pattern = "dd/MM/yyyy";

	public BookService() {

		dao = new BookDAO();

		dateFormat = new SimpleDateFormat(pattern);

	}

	public void create(Book book) {

		BookEntity entity = new BookEntity();

		try {

			entity.setTitle(book.getTitle());
			entity.setType(book.getType());
			entity.setDate(dateFormat.parse(book.getDate()));
			entity.setPrice(book.getPrice());

			setAuthors(entity, book.getAuthors());

			dao.create(entity);

		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	private void setAuthors(BookEntity entity, List<Author> authors) {

		entity.setAuthors(new ArrayList<AuthorEntity>());

		for (Author author : authors) {

			AuthorEntity authorEntity = new AuthorEntity();
			authorEntity.setName(author.getName());
			authorEntity.setId(author.getId());

			entity.getAuthors().add(authorEntity);

		}

	}

	public List<Book> getAll() {

		List<Book> result = new ArrayList<Book>();

		List<BookEntity> books = dao.getAll();

		for (BookEntity book : books) {

			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String date = sdf.format(book.getDate());

			result.add(new Book(book.getTitle(), book.getType(), date, book.getPrice()));
		}
		
		return result;

	}

}
