package com.jose.books.data.book.retrofit.model;

/**
 * Created by jose on 7/07/16.
 */
public class OLBook {
  String title;
  String subtitle;
  int cover_i;
  Integer[] publish_year;
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

  public Integer[] getPublish_year() {
    return publish_year;
  }

  public String[] getAuthor_name() {
    return author_name;
  }

  public String getKey() {
    return key;
  }
}
