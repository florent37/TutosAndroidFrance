package com.tutosandroidfrance.okhttpsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient client = new OkHttpClient();

        //exemple de GET
        client.newCall(new Request.Builder()
                .get()
                .url("https://api.github.com/users/florent37")
                .build()).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });

        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        client.newCall(new Request.Builder()
                .post(JSON, json);).build().

        )
    }

}
