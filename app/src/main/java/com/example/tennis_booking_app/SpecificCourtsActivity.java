package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class SpecificCourtsActivity extends AppCompatActivity {

    TextView txtType;
    ListView lvSpecific;
    ArrayList<SanTennis> arrSan;
    Adapter sanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_courts);

        txtType = findViewById(R.id.txtType);
        lvSpecific = (ListView) findViewById(R.id.lvSpecificCourt);
        AnhXa();

        lvSpecific.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SpecificCourtsActivity.this, Booking.class);
                SanTennis sanTennis = arrSan.get(position);
                intent.putExtra("sandetail", (Serializable) sanTennis);
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){
        arrSan = new ArrayList<>();
        Intent intent = getIntent();
        String noiDung = intent.getStringExtra("Type");
        if(noiDung.equals("Clay")){
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay));
//            sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
//            lvSpecific.setAdapter((ListAdapter) sanAdapter);
        }else if(noiDung.equals("Hard")){
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard));
//            sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
//            lvSpecific.setAdapter((ListAdapter) sanAdapter);
        }else if(noiDung.equals("Grass")){
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass));
//            sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
//            lvSpecific.setAdapter((ListAdapter) sanAdapter);
        }else{
            arrSan.add(new SanTennis("ABC123", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("ABC123", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("ABC123", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("ABC123", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("ABC123", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("ABC123", "300m2", "150.000 đồng", R.drawable.ic_grass));
            arrSan.add(new SanTennis("ABC123", "300m2", "150.000 đồng", R.drawable.ic_grass));
//            sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
//            lvSpecific.setAdapter((ListAdapter) sanAdapter);
        }
        sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
        lvSpecific.setAdapter((ListAdapter) sanAdapter);
    }
}