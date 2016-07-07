package com.jose.books.domain.model;

/**
 * Created by jose on 7/07/16.
 */
public class Book {
    private String image;
    private String title;
    private String author;
    private int publishYear;
    private String id;

    public Book(String id, String title, String author, String image){
        this.image = image;
        this.author = author;
        this.image = image;
        this.title = title;
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getId() {
        return id;
    }
}
