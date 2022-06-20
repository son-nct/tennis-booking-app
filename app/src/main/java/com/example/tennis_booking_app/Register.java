package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
     private EditText tvPhoneee;
     private EditText EdEmail;
     private EditText EdEmaill;
     private Button btnContinue2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tvPhoneee = (EditText) findViewById(R.id.tvPhoneee);
        EdEmail = (EditText) findViewById(R.id.EdEmail);
        EdEmaill =(EditText) findViewById(R.id.EdEmaill);
        btnContinue2 = (Button) findViewById(R.id.btnContinue2);
        btnContinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}