package com.tutosandroidfrance.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS = "PREFS";
    private static final String PREFS_AGE = "PREFS_AGE";
    private static final String PREFS_NAME = "PREFS_NAME";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getBaseContext().getSharedPreferences(PREFS, MODE_PRIVATE);

        //objectif : sauvegarder 1 seule fois le nom et l'age de l'utilisateur

        //pour cela, on commence par regarder si on a déjà des éléments sauvegardés
        if (sharedPreferences.contains(PREFS_AGE) && sharedPreferences.contains(PREFS_NAME)) {

            int age = sharedPreferences.getInt(PREFS_AGE, 0);
            String name = sharedPreferences.getString(PREFS_NAME, null);

            Toast.makeText(this, "Age: " + age + " name: " + name, Toast.LENGTH_SHORT).show();

        } else {
            //si aucun utilisateur n'est sauvegardé, on ajouter [24,florent]
            sharedPreferences
                    .edit()
                    .putInt(PREFS_AGE, 24)
                    .putString(PREFS_NAME, "florent")
                    .apply();

            Toast.makeText(this, "Sauvegardé, relancez l'application pour voir le résultat", Toast.LENGTH_SHORT).show();
        }
    }

}
