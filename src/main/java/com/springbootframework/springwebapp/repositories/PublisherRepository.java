package com.springbootframework.springwebapp.repositories;

import com.springbootframework.springwebapp.model.Book;
import com.springbootframework.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
