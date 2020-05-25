package com.example.resttest.models;


import com.example.resttest.controllers.BookController;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.io.Serializable;

public class Book extends RepresentationModel implements Serializable {
    private String title;
    private String author;
    private int id;
    private static final long serialVersionUID=1;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @JsonProperty
    public Link getLink() {
        Link link1 = null;
        if (!this.hasLink("all_books")) {
            link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).allBooks()).withRel("all_books");
            this.add(link1);
        }
        return link1;
    }

    @JsonProperty
    public Link getOtherLink() {

        Link link1 = null;
        if (!this.hasLink("delete_book")) {
            link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).deleteByID(id)).withRel("delete_book");
            this.add(link1);
        }
        return link1;
    }

    @JsonProperty
    public Link getThirdLink() {
        Link link1 = null;
        if (!this.hasLink("add_book")) {
            link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).addBook(this)).withRel("add_book");
            this.add(link1);
        }
        return link1;
    }
}
