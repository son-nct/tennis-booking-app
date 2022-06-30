package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ImageView imgPromo;
    ImageView imgSearchBar, imgHard, imgClay, imgGrass, imgUser, imgHistory, imgNearMe;
    List<SanKM> arrSanPromo, arrLovedCourt;
    Adapter sanAdapter;
    HorizontalAdapter horizontalAdapter, horizontalAdapterLoved;
    RecyclerView viewPromo, viewLoved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imgSearchBar = (ImageView) findViewById(R.id.imgSearchBar);
        imgPromo = (ImageView) findViewById(R.id.imgPromo);
        imgClay = (ImageView) findViewById(R.id.imgClay);
        imgHard = (ImageView) findViewById(R.id.imgHard);
        imgGrass = (ImageView) findViewById(R.id.imgGrass);
        imgUser = (ImageView) findViewById(R.id.imgUser);
        imgHistory = (ImageView) findViewById(R.id.imgHistory);
        imgNearMe = (ImageView) findViewById(R.id.imgLocation);

        viewPromo = (RecyclerView) findViewById(R.id.viewPromo);
        viewLoved = (RecyclerView) findViewById(R.id.viewLovedCourt);
        arrSanPromo = new ArrayList<>();
        arrLovedCourt = new ArrayList<>();
        horizontalAdapter = new HorizontalAdapter(this, arrSanPromo);
        horizontalAdapterLoved = new HorizontalAdapter(this, arrLovedCourt);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager mLayoutLoved = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLayoutLoved.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewPromo.setLayoutManager(mLayoutManager);
        viewPromo.setItemAnimator(new DefaultItemAnimator());
        viewPromo.setAdapter(horizontalAdapter);

        viewLoved.setLayoutManager(mLayoutLoved);
        viewLoved.setItemAnimator(new DefaultItemAnimator());
        viewLoved.setAdapter(horizontalAdapterLoved);

        initData();
        initDataLoved();

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
                intent.putExtra("sandetail", "Hard");
                startActivity(intent);
            }
        });

        imgClay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Clay");
                startActivity(intent);
            }
        });

        imgGrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Grass");
                startActivity(intent);
            }
        });

        imgNearMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Near Me");
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){
    }

    private void initData(){
        arrSanPromo.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "4.9", "4.3"));
        arrSanPromo.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "4.1", "4.3"));
        arrSanPromo.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "4.2", "4.3"));
        arrSanPromo.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "4.9", "4.3"));
        arrSanPromo.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "5", "4.3"));
        arrSanPromo.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "5", "4.3"));
        horizontalAdapter.notifyDataSetChanged();
    }

    private void initDataLoved(){
        arrLovedCourt.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "4.9","4.3"));
        arrLovedCourt.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "5", "4.3"));
        arrLovedCourt.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "5", "4.3"));
        arrLovedCourt.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "5", "4.3"));
        arrLovedCourt.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "5", "4.3"));
        arrLovedCourt.add(new SanKM("Sân Thủ Đức", "100m2", "100.000 đồng", "TENNISTODAY", R.drawable.san1a, "5", "4.3"));
        horizontalAdapterLoved.notifyDataSetChanged();
    }


}