package com.jose.books.app.executor;

/**
 * Created by jose on 7/07/16.
 */
public interface MainThreadExecutor {

    void execute(Runnable runnable);
}