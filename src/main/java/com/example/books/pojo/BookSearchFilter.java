package com.example.books.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookSearchFilter {

    private String name;

    private String author;

    private List<String> tagList;

    private boolean allTags;
}
