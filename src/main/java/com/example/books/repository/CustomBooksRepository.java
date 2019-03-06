package com.example.books.repository;

import com.example.books.pojo.Book;
import com.example.books.pojo.BookSearchFilter;

import java.util.List;

public interface CustomBooksRepository {

    List<Book> findBooksByFilter(BookSearchFilter bookSearchFilter);
}
