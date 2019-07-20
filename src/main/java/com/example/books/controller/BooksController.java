package com.example.books.controller;

import com.example.books.pojo.Book;
import com.example.books.pojo.BookSearchFilter;
import com.example.books.pojo.Tag;
import com.example.books.service.BooksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Books")
@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksService booksService;

    @ApiOperation(value = "Find all books", nickname = "findAllBook")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Book.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.GET, value="/")
    public List<Book> findAllBooks() {
        return this.booksService.findAllBooks();
    }

    @ApiOperation(value = "Find books By Tags", nickname = "findBooksByTags")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Book.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.POST, value="/filter")
    public List<Book> findBooksByTags(@RequestBody BookSearchFilter bookSearchFilter) {
        return this.booksService.findBooksBySearchFilter(bookSearchFilter);
    }

    @ApiOperation(value = "Update one Book", nickname = "updateBook")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.PUT, value="/")
    public void updateTag(@RequestBody Book book) {
        this.booksService.updateBookInfo(book);
    }

    @ApiOperation(value = "Introduce in the data base all books in a path", nickname = "scanBooks")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Book.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method= RequestMethod.POST, value="/scan")
    public void scanBooks(String path) {
        this.booksService.scanBooks(path);
    }

    @ApiOperation(value = "Delete all Books", nickname = "deleteAllBooks")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.DELETE, value="/")
    public void deleteAllBooks() {
        this.booksService.deleteAllBooks();
    }

    @ApiOperation(value = "Delete a Book", nickname = "deleteOneBook")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public void deleteOneBook(@PathVariable String id) {
        this.booksService.deleteOneBook(id);
    }
}
