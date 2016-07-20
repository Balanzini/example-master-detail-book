package com.jose.books.app.exception;


/**
 * Created by jose on 20/07/16.
 */
public class NoAuthorException extends Exception {
  public NoAuthorException(){
    super("Error find Author");
  }
}
