package br.com.devteixeira.bookstore.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.devteixeira.bookstore.models.Author;
import br.com.devteixeira.bookstore.models.Book;
import br.com.devteixeira.bookstore.services.AuthorService;
import br.com.devteixeira.bookstore.services.BookService;

@ManagedBean
@ViewScoped
public class BookBean {

	private Book book;
	private List<Author> authors;
	private Long authorId;
	private BookService bookService;
	private AuthorService authorService;
	
	public BookBean() {
		
		book = new Book();
		bookService = new BookService();
		authorService = new AuthorService();
		
		authors = authorService.getAll();
		
	}

	public void create() {
		
		try {
			
			bookService.create(book);
			
		} catch (RuntimeException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void saveAuthor() {
		
		Author author = authorService.getById(authorId);		
		this.book.getAuthors().add(author);
		
	}
	
	
	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
