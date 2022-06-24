package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SpecificCourtsActivity extends AppCompatActivity {

    TextView txtType;
    RelativeLayout loHard, loClay, loGrass, loSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_courts);

        txtType = findViewById(R.id.txtType);
        loHard = (RelativeLayout) findViewById(R.id.layoutHard);
        loClay = (RelativeLayout) findViewById(R.id.layoutClay);
        loGrass = (RelativeLayout) findViewById(R.id.layoutGrass);
        loSearch = (RelativeLayout) findViewById(R.id.layoutSearch);

        loHard.setVisibility(View.GONE);
        loClay.setVisibility(View.GONE);
        loGrass.setVisibility(View.GONE);
        loSearch.setVisibility(View.GONE);

        Intent intent = getIntent();
        String noiDung = intent.getStringExtra("Type");

        if(noiDung.equals("Hard")){
            txtType.setText("Hard courts");
            loHard.setVisibility(View.VISIBLE);
            loClay.setVisibility(View.GONE);
            loGrass.setVisibility(View.GONE);
            loSearch.setVisibility(View.GONE);
        }else if(noiDung.equals("Grass")){
            txtType.setText("Grass courts");
            loHard.setVisibility(View.GONE);
            loClay.setVisibility(View.GONE);
            loGrass.setVisibility(View.VISIBLE);
            loSearch.setVisibility(View.GONE);
        }else if(noiDung.equals("Clay")){
            txtType.setText("Clay courts");
            loHard.setVisibility(View.GONE);
            loClay.setVisibility(View.VISIBLE);
            loGrass.setVisibility(View.GONE);
            loSearch.setVisibility(View.GONE);
        }else{
            txtType.setText(noiDung);
            loHard.setVisibility(View.GONE);
            loClay.setVisibility(View.GONE);
            loGrass.setVisibility(View.GONE);
            loSearch.setVisibility(View.VISIBLE);
        }
    }
}