package com.example.books.repository;

import com.example.books.pojo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BooksRepository extends MongoRepository<Book, String>, CustomBooksRepository {

    List<Book> findAll();
    List<Book> findByNameContaining(String name);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByTagListContains(List<String> tags);
    void deleteAll();

    @Override
    <S extends Book> S save(S s);
}
