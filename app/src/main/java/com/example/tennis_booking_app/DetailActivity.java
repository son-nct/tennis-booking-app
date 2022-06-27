package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtTenSan, txtSanSoBaoNhieu;
    ImageView imgHinhSan;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTenSan = (TextView) findViewById(R.id.txtTenSan);
        txtSanSoBaoNhieu = (TextView) findViewById(R.id.txtSanSoBaoNhieu);
        imgHinhSan = (ImageView) findViewById(R.id.imgHinhSan);

        intent = getIntent();

        History history = (History) intent.getSerializableExtra("detailBooking");

        txtTenSan.setText(history.getTen());
    }
}