package com.example.books.service;

import com.example.books.pojo.Book;
import com.example.books.pojo.BookSearchFilter;

import java.util.List;

public interface BooksService {

    List<Book> findAllBooks();
    List<Book> findBooksBySearchFilter(BookSearchFilter filter);
    void deleteAllBooks();
    void updateBookInfo(Book book);
    void scanBooks(String path);

}
