package com.example.tennis_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ThanhCong extends AppCompatActivity {
    ImageButton imgTC;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_cong);

        imgTC=(ImageButton) findViewById(R.id.imgHomeTC);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ThanhCong.this, HomeActivity.class);
                startActivity(intent);
            }
        }, 1000);

        imgTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThanhCong.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}