package com.jose.books.domain;

/**
 * Created by jose on 7/07/16.
 */
public class Book {
    private String image;
    private String title;
    private String author;

    public Book(String title, String author, String image){
        this.image = image;
        this.author = author;
        this.image = image;
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
}
