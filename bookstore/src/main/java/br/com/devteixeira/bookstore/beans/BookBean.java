package br.com.devteixeira.bookstore.beans;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.devteixeira.bookstore.models.Author;
import br.com.devteixeira.bookstore.models.Book;
import br.com.devteixeira.bookstore.services.AuthorService;
import br.com.devteixeira.bookstore.services.BookService;

@ManagedBean
@ViewScoped
public class BookBean {

	private Book book;
	private List<Book> books;
	private List<Author> authors;
	private Long authorId;
	private BookService bookService;
	private AuthorService authorService;
	private HashMap<Long, Author> authorMap = new HashMap<>();
	
	public BookBean() {
		
		book = new Book();
		bookService = new BookService();
		authorService = new AuthorService();
		
		authors = authorService.getAll();
		books = bookService.getAll();
		
	}

	public void create() {
		
		if(book.getAuthors().isEmpty()) {
			
			FacesContext.getCurrentInstance().addMessage("author", new FacesMessage("This book must have at least one author"));
			
			return;
		}
		
		bookService.create(book);
		
	}
	
	public void saveAuthor() throws ValidatorException {
		
		Author author = authorService.getById(authorId);
		
		if(authorMap.containsKey(author.getId())) {
			FacesContext.getCurrentInstance().addMessage("author", new FacesMessage("The author has already added"));
			return;
		}
		
		this.book.getAuthors().add(author);
		this.authorMap.put(authorId, author);
		
	}
	
	
	
	public void mustBePositiveNumberValidator(FacesContext fc, UIComponent component, Object inputValue) throws ValidatorException {
		
		try {
			
			BigDecimal price = new BigDecimal(inputValue.toString());
			
			if(price.compareTo(BigDecimal.ZERO) < 0) {
				throw new ValidatorException(new FacesMessage("The price must be a positive number")); 
			}
			
			if(price.compareTo(BigDecimal.ZERO) == 0) {
				throw new ValidatorException(new FacesMessage("The price cant' be zero")); 
			}
			
		} catch(NumberFormatException e) {
			
			throw new ValidatorException(new FacesMessage("The price must be numeric")); 
			
		}
		
	}
	
	public void mustBeValidDateValidator(FacesContext fc, UIComponent component, Object inputValue) throws ValidatorException {
		
		final String pattern = "dd/MM/yyyy";		
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		
		try {
			
			dateFormat.parse(inputValue.toString());
			
		} catch (ParseException e) {
			throw new ValidatorException(new FacesMessage("The date release date must follow the dd/mm/yyyy format"));
		}
		
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
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
