package com.jose.books.app.base;

import android.app.Activity;
import android.os.Bundle;

import com.jose.books.app.di.component.ActivityComponent;
import com.jose.books.app.di.component.DaggerActivityComponent;


/**
 * Created by jose on 4/07/16.
 */
public abstract class BaseActivity extends Activity {

    protected ActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setComponent();
        doInjection();
    }

    private void setComponent(){
        component = DaggerActivityComponent
                .builder()
                .applicationComponent(((BaseApplication)getApplication()).getApplicationComponent())
                .build();
    }

    protected abstract void doInjection();

}
