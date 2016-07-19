package com.jose.books.ui.main.view;

import android.os.Bundle;
import com.jose.books.R;
import com.jose.books.app.base.BaseActivity;

/**
 * Created by jose on 19/07/16.
 */
public class MainActivity extends BaseActivity implements MainView {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
  }

  @Override
  protected void doInjection() {
    component.inject(this);
  }
}
