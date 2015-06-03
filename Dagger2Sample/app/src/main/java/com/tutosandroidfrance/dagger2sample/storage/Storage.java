package com.tutosandroidfrance.dagger2sample.storage;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by florentchampigny on 03/06/15.
 */
public class Storage {
    protected final String SHARED_PREFERENCES = "StorageModule";
    protected final String PREFERENCES_API_KEY = "PREFERENCES_API_KEY";

    Context context;

    SharedPreferences sharedPreferences;

    public Storage(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    public String getApiKey() {
        return this.sharedPreferences.getString(PREFERENCES_API_KEY, null);
    }

    public void setApiKey(String apiKey) {
        this.sharedPreferences.edit().putString(PREFERENCES_API_KEY, apiKey).apply();
    }
}
