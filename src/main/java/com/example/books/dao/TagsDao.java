package com.example.books.dao;

import com.example.books.pojo.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagsDao extends MongoRepository<Tag, String> {

    List<Tag> findAll();
    Tag insert(Tag tag);
    void deleteById(String id);
}
