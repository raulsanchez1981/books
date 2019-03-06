package com.example.books.controller;

import com.example.books.pojo.Tag;
import com.example.books.service.TagsServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Tags")
@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    TagsServices tagsServices;

    @ApiOperation(value = "Obtain all Tags", nickname = "findAllTags")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Tag.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.GET, value="/")
    public List<Tag> findAllTags() {
        return this.tagsServices.findAll();
    }

    @ApiOperation(value = "Insert one Tag", nickname = "insertTag")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.POST, value="/")
    public void insertTag(@RequestBody Tag tag) {
        this.tagsServices.insertTag(tag);
    }

    @ApiOperation(value = "Update one Tag", nickname = "updateTag")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.PUT, value="/")
    public void updateTag(@RequestBody Tag tag) {
        this.tagsServices.updateTag(tag);
    }

    @ApiOperation(value = "Delete one Tag", nickname = "deleteTagById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.DELETE, value="/")
    public void deleteTagById(String id) {
        this.tagsServices.deleteTag(id);
    }
}
