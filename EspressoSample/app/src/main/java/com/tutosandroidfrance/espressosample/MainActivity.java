package com.tutosandroidfrance.espressosample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.login) Button login;
    @Bind(R.id.editText) EditText editText;
    @Bind(R.id.loginContainer) View loginContainer;
    @Bind(R.id.textContainer) View textContainer;
    @Bind(R.id.text) TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void onLoginClicked(){
        String name = editText.getText().toString();
        if(!name.isEmpty()) {
            closeKeyboard(editText);

            //hide views
            loginContainer.setVisibility(View.GONE);
            textContainer.setVisibility(View.VISIBLE);

            //display
            text.setText("Hello " + name);
        }
    }

    private void closeKeyboard(View view){
        //close keyboard
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
