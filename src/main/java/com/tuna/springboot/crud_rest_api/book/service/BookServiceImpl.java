package com.tuna.springboot.crud_rest_api.book.service;

import com.tuna.springboot.crud_rest_api.book.entity.Book;
import com.tuna.springboot.crud_rest_api.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}
	
	@Override
	public Book findById(int theId) {
		Optional<Book> result = this.bookRepository.findById(theId);
		
		Book theBook = null;
		
		if (result.isPresent()) {
			theBook = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find book id - " + theId);
		}
		
		return theBook;
	}
	
	@Override
	public Book save(Book theBook) {
		return this.bookRepository.save(theBook);
	}
	
	@Override
	public void deleteById(int theId) {
		this.bookRepository.deleteById(theId);
	}
}
