package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ImageView imgPromo;
    ImageView imgSearchBar, imgHard, imgClay, imgGrass, imgUser, imgHistory;
    ArrayList<SanTennis> arrSan;
    SanAdapter sanAdapter;
    ListView lvUuDai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lvUuDai = (ListView) findViewById(R.id.lvUuDai);
        imgSearchBar = (ImageView) findViewById(R.id.imgSearchBar);
        imgPromo = (ImageView) findViewById(R.id.imgPromo);
        imgClay = (ImageView) findViewById(R.id.imgClay);
        imgHard = (ImageView) findViewById(R.id.imgHard);
        imgGrass = (ImageView) findViewById(R.id.imgGrass);
        imgUser = (ImageView) findViewById(R.id.imgUser);
        imgHistory = (ImageView) findViewById(R.id.imgHistory);

        AnhXa();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#AFF8A3"));
        }

        imgPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Promotion.class);
                startActivity(intent);
            }
        });

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DangXuat.class);
                startActivity(intent);
            }
        });

        imgHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LichSu.class);
                startActivity(intent);
            }
        });

        imgSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SearchPageActivity.class);
                startActivity(intent);
            }
        });

        imgHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("Type", "Hard");
                startActivity(intent);
            }
        });

        imgClay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("Type", "Clay");
                startActivity(intent);
            }
        });

        imgGrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("Type", "Grass");
                startActivity(intent);
            }
        });

        lvUuDai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, YardDetail.class);
                SanTennis sanTennis =arrSan.get(position);
                intent.putExtra("sandetail", (Serializable) sanTennis );
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){
        arrSan = new ArrayList<>();
        arrSan.add(new SanTennis("Sân Thủ Đức", "300m2", "150.000 đồng", R.drawable.san1a));
        arrSan.add(new SanTennis("Sân Thủ Đức 1", "300m2", "150.000 đồng", R.drawable.san1a));
        arrSan.add(new SanTennis("Sân Thủ Đức 2", "300m2", "150.000 đồng", R.drawable.san1a));
        arrSan.add(new SanTennis("Sân Thủ Đức 3", "300m2", "150.000 đồng", R.drawable.san1a));
        arrSan.add(new SanTennis("Sân Thủ Đức 4", "300m2", "150.000 đồng", R.drawable.san1a));
        arrSan.add(new SanTennis("Sân Thủ Đức 5", "300m2", "150.000 đồng", R.drawable.san1a));
        arrSan.add(new SanTennis("Sân Thủ Đức 6", "300m2", "150.000 đồng", R.drawable.san1a));
        sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
        lvUuDai.setAdapter(sanAdapter);
    }
}