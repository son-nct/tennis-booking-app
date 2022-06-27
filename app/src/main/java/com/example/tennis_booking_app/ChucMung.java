package com.example.tennis_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ChucMung extends AppCompatActivity {
    ImageButton imgCM;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_mung);

        imgCM=(ImageButton) findViewById(R.id.imgHomeCM);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ChucMung.this, HomeActivity.class);
                startActivity(intent);
            }
        }, 2000);

        imgCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChucMung.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}