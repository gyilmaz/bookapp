package com.springbootframework.springwebapp.bootstrap;

import com.springbootframework.springwebapp.model.Author;
import com.springbootframework.springwebapp.model.Book;
import com.springbootframework.springwebapp.model.Publisher;
import com.springbootframework.springwebapp.repositories.AuthorRepository;
import com.springbootframework.springwebapp.repositories.BookRepository;
import com.springbootframework.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    public AuthorRepository authorRepository;
    public BookRepository bookRepository;
    public PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    private void initData(){


        Author eric = new Author("Eric", "Evans");
        Publisher pub= new Publisher("Cambridge","London");
        Book ddd= new Book("JPA","1234");
        pub.setBook(ddd);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);



        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);

        Author bob = new Author("Bob", "Smith");
        Publisher pub2= new Publisher("Princeton","Miami");
        Book eee= new Book("DPA","2233");
        pub2.setBook(eee);
        bob.getBooks().add(eee);
        eee.getAuthors().add(bob);



        authorRepository.save(bob);
        bookRepository.save(eee);
        publisherRepository.save(pub2);




    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
