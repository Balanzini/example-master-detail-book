package com.jose.books.ui.main.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jose.books.R;
import com.jose.books.app.base.BaseActivity;
import com.jose.books.ui.main.presenter.MainPresenter;
import javax.inject.Inject;

/**
 * Created by jose on 19/07/16.
 */
public class MainActivity extends BaseActivity implements MainView {

  @Inject MainPresenter presenter;

  @Bind(R.id.et_search_text) EditText etText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
    ButterKnife.bind(this);
  }

  @Override
  protected void doInjection() {
    component.inject(this);

  }

  @OnClick(R.id.bttn_search)
  public void onSearch(){
    presenter.onSearchSelected(etText.getText().toString());
  }
}
