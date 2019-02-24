package com.example.books.service;

import com.example.books.pojo.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TagsServices {

    List<Tag> findAll();
    void insertTag(Tag tag);
    void updateTag(Tag tag);
    void deleteTag(String id);
}
