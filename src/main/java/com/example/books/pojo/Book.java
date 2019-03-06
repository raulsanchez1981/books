package com.example.books.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@Document(collection = "books")
public class Book implements Serializable {

    @Id
    @ApiModelProperty(notes = "The id of the book", required = true, hidden = true)
    private String id;
    @NotNull
    private String name;

    private String author;

    private String path;

    private List<String> tagList;


}
