package com.example.tennis_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChucMung extends AppCompatActivity {
    ImageButton imgCM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_mung);

        imgCM=(ImageButton) findViewById(R.id.imgHomeCM);
        imgCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChucMung.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}