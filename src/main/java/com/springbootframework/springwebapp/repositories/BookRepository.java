package com.springbootframework.springwebapp.repositories;

import com.springbootframework.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
