package com.jose.books.app.di.component;

import com.jose.books.app.di.module.PresenterModule;
import com.jose.books.app.di.scope.ActivityScope;
import com.jose.books.ui.list.view.BookListActivity;

import dagger.Component;

/**
 * Created by jose on 5/07/16.
 */
@Component(dependencies = ApplicationComponent.class, modules = PresenterModule.class)
@ActivityScope
public interface ActivityComponent {

    void inject(BookListActivity bookListActivity);
}
