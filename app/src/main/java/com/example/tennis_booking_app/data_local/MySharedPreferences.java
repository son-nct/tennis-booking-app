package com.example.tennis_booking_app.data_local;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static final String MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    private Context context;

    public MySharedPreferences(Context context) {
        this.context = context;
    }

    // demo
    public void putBooleanValue(String key, boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}