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
                intent.putExtra("sandetail", "Sân cứng");
                startActivity(intent);
            }
        });

        imgClay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Sân đất nện");
                startActivity(intent);
            }
        });

        imgGrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Sân cỏ");
                startActivity(intent);
            }
        });

        imgNearMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Gần tôi");
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){
    }

    private void initData(){
        // String ten, String dientich, String tien, String promotionStatus, int hinh, String rating, String khoangCach
        arrSanPromo.add(new SanKM("Sân Thủ Đức", "Quận Thủ Đức", "Từ 100.000 đến 300.000 vnđ",  "Khuyến mãi đến 50 000 vnd",  R.drawable.san1a, "4.9", "2.3km"));
        arrSanPromo.add(new SanKM("Sân Kim Sa", "Quận 10","Từ 100.000 đến 300.000 vnđ", "Khuyến mãi đến 50 000 vnd", R.drawable.san1a, "4.1", "10.4km"));
        arrSanPromo.add(new SanKM("Sân Lam Sơn", "Quận Tân Bình", "Từ 100.000 đến 300.000 vnđ","Khuyến mãi đến 50 000 vnd", R.drawable.san1a, "4.2", "20km"));
        arrSanPromo.add(new SanKM("Sân Hoàng Sa", "Quận 5", "Từ 100.000 đến 300.000 vnđ","Khuyến mãi đến 50 000 vnd", R.drawable.san1a, "4.9", "12km"));
        arrSanPromo.add(new SanKM("Sân Trường Sa", "Quận 5","Từ 100.000 đến 300.000 vnđ","Khuyến mãi đến 50 000 vnd", R.drawable.san1a, "5", "12.8km"));
        arrSanPromo.add(new SanKM("Sân Quận 7", "Quận 7","Từ 100.000 đến 300.000 vnđ","Khuyến mãi đến 50 000 vnd", R.drawable.san1a, "5", "9.6km"));
        horizontalAdapter.notifyDataSetChanged();
    }

    private void initDataLoved(){
        arrLovedCourt.add(new SanKM("Sân 1A", "36.57m x 18.29m", "100.000 vnd", "TENNISTODAY", R.drawable.san1a, "4.9","4.3km"));
        arrLovedCourt.add(new SanKM("Sân 2A", "36.57m x 18.29m", "100.000 vnd", "ABCXYZ", R.drawable.san1a, "5", "4.3km"));
        arrLovedCourt.add(new SanKM("Sân 2B", "36.57m x 18.29m", "100.000 vnd", "AAAAAA", R.drawable.san1a, "5", "4.3km"));
        arrLovedCourt.add(new SanKM("Sân 3C", "36.57m x 18.29m", "100.000 vnd", "XXXXXXX", R.drawable.san1a, "5", "4.3km"));
        arrLovedCourt.add(new SanKM("Sân 2C", "36.57m x 18.29m", "100.000 vnd", "ZZZZZ", R.drawable.san1a, "5", "4.3km"));
        arrLovedCourt.add(new SanKM("Sân 4", "36.57m x 18.29m", "100.000 vnd", "DAASDASDAD", R.drawable.san1a, "5", "4.3km"));
        horizontalAdapterLoved.notifyDataSetChanged();
    }


}