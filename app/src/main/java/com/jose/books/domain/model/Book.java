package com.jose.books.domain.model;

/**
 * Created by jose on 7/07/16.
 */
public class Book {
    private String imageId;
    private String title;
    private String author;
    private int publishYear;
    private String id;

    public Book(String id, String title, String author, String imageId){
        this.imageId = imageId;
        this.author = author;
        this.imageId = imageId;
        this.title = title;
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
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
