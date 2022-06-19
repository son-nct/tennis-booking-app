package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginFacebookGoogleActivity extends AppCompatActivity {

    Button btnFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook_google);

        btnFacebook = (Button) findViewById(R.id.btnLoginWithFacebook);

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginFacebookGoogleActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}