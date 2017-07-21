package com.jose.books.app.executor.main;

import com.jose.books.app.executor.Executor;

/**
 * Created by jose on 9/02/17.
 */
public interface MainThreadExecutor<T extends Runnable> extends Executor<T> {
}
