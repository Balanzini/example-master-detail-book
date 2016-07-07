package com.jose.books.app.di.module;

import com.jose.books.app.executor.InteractorExecutor;
import com.jose.books.app.executor.InteractorExecutorImp;
import com.jose.books.app.executor.MainThreadExecutor;
import com.jose.books.app.executor.MainThreadExecutorImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 7/07/16.
 */
@Module
public class ExecutorModule {

    @Provides
    @Singleton
    public InteractorExecutor providerInteractorExecutor() {
        return new InteractorExecutorImp();
    }

    @Provides
    @Singleton
    public MainThreadExecutor providerMainThreadExecutor() {
        return new MainThreadExecutorImp();
    }
}
