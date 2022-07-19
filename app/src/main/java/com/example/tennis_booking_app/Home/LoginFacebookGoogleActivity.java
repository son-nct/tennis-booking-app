package com.example.tennis_booking_app.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.StartsActivity;

public class LoginFacebookGoogleActivity extends AppCompatActivity {

    Button  btnPhone;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook_google);


        btnPhone = (Button) findViewById(R.id.btnLoginWithPhoneNumber);


        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginFacebookGoogleActivity.this, StartsActivity.class);
                startActivity(intent);
            }
        });
    }
}