package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginFacebookGoogleActivity extends AppCompatActivity {

    Button btnFacebook, btnPhone;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook_google);

        btnFacebook = (Button) findViewById(R.id.btnLoginWithFacebook);
        btnPhone = (Button) findViewById(R.id.btnLoginWithPhoneNumber);

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginFacebookGoogleActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginFacebookGoogleActivity.this, StartsActivity.class);
                startActivity(intent);
            }
        });
    }
}