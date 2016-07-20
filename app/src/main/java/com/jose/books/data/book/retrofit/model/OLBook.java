package com.jose.books.data.book.retrofit.model;

import com.jose.books.app.exception.NoAuthorException;

/**
 * Created by jose on 7/07/16.
 */
public class OLBook {
  String title;
  String subtitle;
  int cover_i;
  int first_publish_year;
  String[] author_name;
  String key;

  public String getTitle() {
    return title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public int getCover_i() {
    return cover_i;
  }

  public int getPublish_year() {
    return first_publish_year;
  }

  public String[] getAuthor_name() throws NoAuthorException{
    if(author_name == null){
      throw new NoAuthorException();
    }
    else {
      return author_name;
    }
  }

  public String getKey() {
    return key;
  }
}
