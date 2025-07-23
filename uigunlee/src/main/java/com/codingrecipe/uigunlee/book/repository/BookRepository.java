package com.codingrecipe.uigunlee.book.repository;

import com.codingrecipe.uigunlee.book.entity.Book;
import com.codingrecipe.uigunlee.book.service.response.RegisterBookResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    RegisterBookResponse register();
}
