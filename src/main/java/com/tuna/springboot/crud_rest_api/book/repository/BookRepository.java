package com.tuna.springboot.crud_rest_api.book.repository;

import com.tuna.springboot.crud_rest_api.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
