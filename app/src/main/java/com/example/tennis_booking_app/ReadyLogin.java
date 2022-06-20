package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ReadyLogin extends AppCompatActivity {
     private Button btnDang;
    RelativeLayout layoutWait, layoutSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_login);

        btnDang = (Button)findViewById(R.id.btnDang);
        layoutWait = (RelativeLayout) findViewById(R.id.layoutWaiting);
        layoutSelect = (RelativeLayout) findViewById(R.id.layoutSelect);

        layoutSelect.setVisibility(View.GONE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                layoutWait.setVisibility(View.GONE);
                layoutSelect.setVisibility(View.VISIBLE);
            }
        },1000);

        btnDang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadyLogin.this,Register.class);
                startActivity(intent);
            }
        });
    }
}