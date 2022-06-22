package com.example.tennis_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ThanhCong extends AppCompatActivity {
    ImageButton imgTC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_cong);

        imgTC=(ImageButton) findViewById(R.id.imgHomeTC);
        imgTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThanhCong.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}