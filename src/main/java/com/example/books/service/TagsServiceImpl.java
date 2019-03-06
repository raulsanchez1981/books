package com.example.books.service;

import com.example.books.repository.TagsRepository;
import com.example.books.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsServiceImpl implements TagsServices{

    @Autowired
    TagsRepository tagsDao;

    @Override
    public List<Tag> findAll() {
        return this.tagsDao.findAll();
    }

    @Override
    public void insertTag(Tag tag) {
        this.tagsDao.insert(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        this.tagsDao.insert(tag);
    }

    @Override
    public void deleteTag(String id) {
        this.tagsDao.deleteById(id);
    }
}
