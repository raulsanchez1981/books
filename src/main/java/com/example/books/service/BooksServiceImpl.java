package com.example.books.service;

import com.example.books.pojo.Book;
import com.example.books.pojo.BookSearchFilter;
import com.example.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRepository booksRepository;

    @Override
    public List<Book> findAllBooks() {
        return this.booksRepository.findAll();
    }

    @Override
    public List<Book> findBooksBySearchFilter(BookSearchFilter filter) {
        return this.booksRepository.findBooksByFilter(filter);
    }


    @Override
    public void deleteAllBooks() {
        this.booksRepository.deleteAll();
    }

    @Override
    public void updateBookInfo(Book book) {
        String sufix = book.getPath().substring(book.getPath().lastIndexOf("."));
        String newName = book.getName()+" - "+book.getAuthor()+sufix;
        Path source = Paths.get(book.getPath());
        try {
            book.setPath(Files.move(source, source.resolveSibling(newName)).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.booksRepository.save(book);
    }

    @Override
    public void scanBooks(String path) {
        try {
            Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .forEach(item -> {
                        Book book = Book.builder()
                                .name(item.getFileName().toString())
                                .path(item.toAbsolutePath().toString())
                                .build();
                        this.booksRepository.save(book);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
