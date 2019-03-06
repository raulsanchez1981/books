package com.example.books.repository;

import com.example.books.pojo.Book;
import com.example.books.pojo.BookSearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.MongoRegexCreator;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import java.util.List;

public class BooksRepositoryImpl implements CustomBooksRepository {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public List<Book> findBooksByFilter(BookSearchFilter bookSearchFilter) {
        Query query = new Query();

        if(!StringUtils.isEmpty(bookSearchFilter.getName())) {
            query.addCriteria(Criteria.where("name").regex(toLikeRegex(bookSearchFilter.getName()), "i"));
        }

        if(!StringUtils.isEmpty(bookSearchFilter.getAuthor())) {
            query.addCriteria(Criteria.where("author").regex(toLikeRegex(bookSearchFilter.getAuthor()), "i"));
        }

        if(!StringUtils.isEmpty(bookSearchFilter.getTagList())) {
            if (true==bookSearchFilter.isAllTags()) {
                query.addCriteria(Criteria.where("tagList").all(bookSearchFilter.getTagList()));
            } else {
                query.addCriteria(Criteria.where("tagList").in(bookSearchFilter.getTagList()));
            }
        }

        List<Book> list = this.mongoTemplate.find(query, Book.class);
        return list;

    }

    private String toLikeRegex(String source) {
        return MongoRegexCreator.INSTANCE.toRegularExpression(source, MongoRegexCreator.MatchMode.LIKE);
    }
}
