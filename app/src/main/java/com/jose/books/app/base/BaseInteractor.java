package com.jose.books.app.base;

import com.jose.books.app.executor.Interactor;
import com.jose.books.app.executor.InteractorExecutor;
import com.jose.books.app.executor.MainThreadExecutor;

/**
 * Created by jose on 7/07/16.
 */
public abstract class BaseInteractor implements Interactor {

    private InteractorExecutor interactorExecutor;
    private MainThreadExecutor mainThreadExecutor;

    public BaseInteractor(InteractorExecutor interactorExecutor,
                          MainThreadExecutor mainThreadExecutor) {
        this.interactorExecutor = interactorExecutor;
        this.mainThreadExecutor = mainThreadExecutor;
    }

    public void executeCurrentInteractor() {
        interactorExecutor.execute(this);
    }

    public void executeInMainThread(Runnable runnable) {
        mainThreadExecutor.execute(runnable);
    }
}
