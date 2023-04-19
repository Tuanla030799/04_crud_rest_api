package com.tuna.springboot.crud_rest_api.book.service;


import com.tuna.springboot.crud_rest_api.book.entity.Book;

import java.util.List;

public interface BookService {
	List<Book> findAll();
	
	Book findById(int theId);
	
	Book save(Book theBook);
	
	void deleteById(int theId);
}
