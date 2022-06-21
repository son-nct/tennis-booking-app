package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SpecificCourtsActivity extends AppCompatActivity {

    TextView txtType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_courts);

        txtType = findViewById(R.id.txtType);

        Intent intent = getIntent();
        String noiDung = intent.getStringExtra("Type");

        if(noiDung.equals("Hard")){
            txtType.setText("Hard courts");
        }else if(noiDung.equals("Grass")){
            txtType.setText("Grass courts");
        }else if(noiDung.equals("Clay")){
            txtType.setText("Clay courts");
        }
    }
}