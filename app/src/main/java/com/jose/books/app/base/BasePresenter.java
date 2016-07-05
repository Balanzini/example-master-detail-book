package com.jose.books.app.base;

import com.jose.books.ui.View;

/**
 * Created by jose on 4/07/16.
 */
public abstract class BasePresenter<T extends View> {

    T view;

    public void setView(T view){
        this.view = view;
    }


}
