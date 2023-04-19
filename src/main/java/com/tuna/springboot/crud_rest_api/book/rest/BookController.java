package com.tuna.springboot.crud_rest_api.book.rest;

import com.tuna.springboot.crud_rest_api.book.entity.Book;
import com.tuna.springboot.crud_rest_api.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public List<Book> findAll() {
		return this.bookService.findAll();
	}
	
	@GetMapping("/books/{bookId}")
	public Book findById(@PathVariable int bookId) {
		Book theBook = this.bookService.findById(bookId);
		
		if (theBook == null) {
			throw new RuntimeException("Book id not found -" + bookId);
		}
		
		return theBook;
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book theBook) {
		theBook.setId(0);
		
		return this.bookService.save(theBook);
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book theBook) {
		return this.bookService.save(theBook);
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		Book tempBook = this.bookService.findById(bookId);
		
		if (tempBook == null) {
			throw new RuntimeException("Book id not found" + bookId);
		}
		
		this.bookService.deleteById(bookId);
		
		return "Delete book id -" + bookId;
	}
}
