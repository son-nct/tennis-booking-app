package com.example.tennis_booking_app.activity.home;

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
import android.widget.ImageView;

import com.example.tennis_booking_app.adapter.home.CourtFavouriteAdapter;
import com.example.tennis_booking_app.DangXuat;
import com.example.tennis_booking_app.adapter.home.HorizontalAdapter;
import com.example.tennis_booking_app.LichSu;
import com.example.tennis_booking_app.Models.Court;
import com.example.tennis_booking_app.Promotion;
import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.SanKM;
import com.example.tennis_booking_app.SearchPageActivity;
import com.example.tennis_booking_app.SpecificCourtsActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ImageView imgPromo;
    ImageView imgSearchBar, imgHard, imgClay, imgGrass, imgUser, imgHistory, imgNearMe;
    List<SanKM> arrSanPromo;
    List<Court> arrCourtFav;
    Adapter sanAdapter;
    HorizontalAdapter horizontalAdapter, horizontalAdapterLoved;
    CourtFavouriteAdapter courtFavouriteAdapter;
    RecyclerView viewPromo, viewFavCourt;

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
        viewFavCourt = (RecyclerView) findViewById(R.id.viewFavCourt);
        arrSanPromo = new ArrayList<>();
        arrCourtFav = new ArrayList<>();
        horizontalAdapter = new HorizontalAdapter(this, arrSanPromo);
        courtFavouriteAdapter = new CourtFavouriteAdapter(this, arrCourtFav);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager mLayoutFavourite = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLayoutFavourite.setOrientation(LinearLayoutManager.HORIZONTAL);

        viewPromo.setLayoutManager(mLayoutManager);
        viewPromo.setItemAnimator(new DefaultItemAnimator());
        viewPromo.setAdapter(horizontalAdapter);

        viewFavCourt.setLayoutManager(mLayoutFavourite);
        viewFavCourt.setItemAnimator(new DefaultItemAnimator());
        viewFavCourt.setAdapter(courtFavouriteAdapter);

        initData();
        initCourtFavourite();

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

    private void AnhXa() {
    }

    private void initData() {
        arrSanPromo.add(new SanKM("Sân Thủ Đức", "Ưu Đãi Đến 45k", "", "Khuyễn Mãi", R.drawable.store_img, "4.9", "2.3km"));
        arrSanPromo.add(new SanKM("Sân Kim Sa", "Siêu Giảm Giá", "", "Khuyễn Mãi", R.drawable.store_img, "4.1", "10.4km"));
        arrSanPromo.add(new SanKM("Sân Lam Sơn", "Nhập LANDAU23...", "", "Khuyễn Mãi", R.drawable.store_img, "4.2", "20km"));
        arrSanPromo.add(new SanKM("Sân Hoàng Sa", "Quận 5", "", "Khuyễn Mãi", R.drawable.store_img, "4.9", "12km"));
        arrSanPromo.add(new SanKM("Sân Trường Sa", "Quận 5", "", "Khuyễn Mãi", R.drawable.store_img, "5", "12.8km"));
        arrSanPromo.add(new SanKM("Sân Quận 7", "Quận 7", "", "Khuyễn Mãi", R.drawable.store_img, "5", "9.6km"));
        horizontalAdapter.notifyDataSetChanged();
    }

    private void initCourtFavourite() {
        arrCourtFav.add(new Court("Sân Cỏ 1A Hoàng Minh", "Hoàng Minh Tennis", "40", "20", "150.000 ~ 200.000đ", R.drawable.tennis_grass));
        arrCourtFav.add(new Court("Sân Đất Nện Thủ Đức", "Thủ Đức Tennis", "36.57", "18.29", "200.000 ~ 350.000đ", R.drawable.tennis_clay));
        arrCourtFav.add(new Court("Sân Cỏ Hoàng Diệu", "Đại Học Ngân Hàng Tennis", "34.75", "17.07", "80.000 ~ 180.000đ", R.drawable.tennis_grass));
        arrCourtFav.add(new Court("Sân Cỏ Chuẩn Thi Đấu", "FPT Tennis", "36.57", "18.29", "150.000 ~ 300.000đ", R.drawable.tennis_clay));
        courtFavouriteAdapter.notifyDataSetChanged();
    }


}