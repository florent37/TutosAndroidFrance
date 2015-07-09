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

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText editText;
    View loginContainer;
    View textContainer;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login);
        editText = (EditText) findViewById(R.id.editText);
        loginContainer = findViewById(R.id.loginContainer);
        textContainer = findViewById(R.id.textContainer);
        text = (TextView) findViewById(R.id.text);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                if(!name.isEmpty()) {
                    //close keyboard
                    InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                    //hide views
                    loginContainer.setVisibility(View.GONE);
                    textContainer.setVisibility(View.VISIBLE);

                    //display
                    text.setText("Hello " + name);
                }
            }
        });
    }

}
