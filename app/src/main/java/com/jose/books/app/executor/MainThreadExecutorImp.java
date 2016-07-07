package com.jose.books.app.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by jose on 7/07/16.
 */
public class MainThreadExecutorImp implements MainThreadExecutor {

    private Handler handler;

    public MainThreadExecutorImp() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
