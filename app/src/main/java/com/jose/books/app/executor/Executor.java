package com.jose.books.app.executor;

/**
 * Created by jose on 9/02/17.
 */
public interface Executor<T extends Runnable> {

  void execute(T runnable);
}
