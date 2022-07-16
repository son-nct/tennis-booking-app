package com.example.tennis_booking_app.activity.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.CourtSizeValue;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.PromoAdapter;
import com.example.tennis_booking_app.Promotion;
import com.example.tennis_booking_app.ViewModels.CourtSize.CourtSizeRequest;
import com.example.tennis_booking_app.ViewModels.CourtSize.CourtSizeResponse;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.example.tennis_booking_app.adapter.home.CourtFavouriteAdapter;
import com.example.tennis_booking_app.DangXuat;
import com.example.tennis_booking_app.adapter.home.HorizontalAdapter;
import com.example.tennis_booking_app.LichSu;
import com.example.tennis_booking_app.Models.Court;
import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.SanKM;
import com.example.tennis_booking_app.PhucHLH.SearchPageActivity;
import com.example.tennis_booking_app.PhucHLH.SpecificCourtsActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ImageView imgSearchBar, imgHard, imgClay, imgGrass, imgUser, imgHistory, imgNearMe, imgPromo;
    List<SanKM> arrSanPromo;
    List<Court> arrCourtFav;
    HorizontalAdapter horizontalAdapter;
    RecyclerView viewPromo, viewFavCourt;
    TextView txtWelcome;
    ArrayList<PagedCourtValue> arrPromoHome;
    ArrayList<PagedCourtValue> arrFavHome;
    List<PagedCourtResponse> arrAPIPaged;
    Token TOKEN;
    String AUTHORIZATION;
    ArrayList<CourtSizeValue> arrSizeResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imgSearchBar = (ImageView) findViewById(R.id.imgSearchBar);
        imgClay = (ImageView) findViewById(R.id.imgClay);
        imgHard = (ImageView) findViewById(R.id.imgHard);
        imgGrass = (ImageView) findViewById(R.id.imgGrass);
        imgUser = (ImageView) findViewById(R.id.imgUser);
        imgHistory = (ImageView) findViewById(R.id.imgHistory);
        imgNearMe = (ImageView) findViewById(R.id.imgLocation);
        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        imgPromo = (ImageView) findViewById(R.id.imgPromo);
        arrAPIPaged = new ArrayList<>();

        viewPromo = (RecyclerView) findViewById(R.id.viewPromo);
        viewFavCourt = (RecyclerView) findViewById(R.id.viewFavCourt);
        arrSanPromo = new ArrayList<>();
        arrCourtFav = new ArrayList<>();

//        horizontalAdapter = new HorizontalAdapter(this, arrSanPromo);
//        courtFavouriteAdapter = new CourtFavouriteAdapter(this, arrPromoHome);
//        LinearLayoutManager mLayoutFavourite = new LinearLayoutManager(getApplicationContext());
//        mLayoutFavourite.setOrientation(LinearLayoutManager.HORIZONTAL);
//        viewFavCourt.setAdapter(courtFavouriteAdapter);
//        arrPageCourtValue = new ArrayList<>();

        arrSizeResponse = new ArrayList<>();

        //get sharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sh.getString("TOKEN", "");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();


        setWelcome();

//        initData();

        loadHighRating();
        loadPromo();

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

    private void setWelcome() {
        Intent intent = getIntent();
//        String welcome = intent.getStringExtra("data");
//        txtWelcome.setText("Xin chào " + welcome);
    }

//    private void initData() {
//        arrSanPromo.add(new SanKM("Sân Thủ Đức", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "4.9", "2.3km"));
//        arrSanPromo.add(new SanKM("Sân Kim Sa", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "4.1", "10.4km"));
//        arrSanPromo.add(new SanKM("Sân Lam Sơn", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "4.2", "20km"));
//        arrSanPromo.add(new SanKM("Sân Hoàng Sa", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "4.9", "12km"));
//        arrSanPromo.add(new SanKM("Sân Trường Sa", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "5", "12.8km"));
//        arrSanPromo.add(new SanKM("Sân Quận 7", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "5", "9.6km"));
//        horizontalAdapter.notifyDataSetChanged();
//    }

    private void loadPromo(){
        PagedCourtRequest paramsRequest = new PagedCourtRequest();
        paramsRequest.setVendorId(11);
        paramsRequest.setPageSize(10);
        paramsRequest.setQueryString("");
        paramsRequest.setCurrentPage(1);

        Call<PagedCourtResponse> pagedCourtResponseCall = ApiClient.getVendorService().getPagedPromoCourt(AUTHORIZATION, paramsRequest.getVendorId(), paramsRequest.getPageSize(), paramsRequest.getQueryString(), paramsRequest.getCurrentPage());
        System.out.println("request promo today url \n" + pagedCourtResponseCall.request().url());
        pagedCourtResponseCall.enqueue(new Callback<PagedCourtResponse>() {
            @Override
            public void onResponse(Call<PagedCourtResponse> call, Response<PagedCourtResponse> response) {
                if(response.code() == 200){
                    // set layout
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                    viewPromo.setLayoutManager(mLayoutManager);
                    viewPromo.setItemAnimator(new DefaultItemAnimator());

                    // handle api data
                    arrPromoHome = new ArrayList<>();
                    PagedCourtResponse pagedCourtResponse = response.body();
                    arrPromoHome = (ArrayList) pagedCourtResponse.getValue();
                    HorizontalAdapter horizontalPromoAdapter = new HorizontalAdapter(HomeActivity.this, arrPromoHome);

                    // set adapter
                    viewPromo.setLayoutManager(mLayoutManager);
                    viewPromo.setAdapter(horizontalPromoAdapter);
                    horizontalPromoAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PagedCourtResponse> call, Throwable t) {

            }
        });
    }


    private void loadHighRating() {
        PagedCourtRequest paramsRequest = new PagedCourtRequest();
        paramsRequest.setCurrentPage(1);
        paramsRequest.setVendorId(11);
        paramsRequest.setQueryString("");
        paramsRequest.setPageSize(7);

        Call<PagedCourtResponse> pagedCourtResponseCall = ApiClient.getVendorService().getPagedListHighRating(AUTHORIZATION, paramsRequest.getVendorId(), paramsRequest.getPageSize(), paramsRequest.getQueryString(), paramsRequest.getCurrentPage());
        System.out.println("request home url \n" + pagedCourtResponseCall.request().url());
            pagedCourtResponseCall.enqueue(new Callback<PagedCourtResponse>() {
                @Override
                public void onResponse(Call<PagedCourtResponse> call, Response<PagedCourtResponse> response) {
                    if (response.code() == 200) {
                        // set horizontal view
                        LinearLayoutManager mLayoutFavourite = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                        viewFavCourt.setLayoutManager(mLayoutFavourite);
                        viewFavCourt.setItemAnimator(new DefaultItemAnimator());
                        // handle api data
                        arrFavHome = new ArrayList<>();
                        PagedCourtResponse pagedCourtResponse = response.body();
                        arrFavHome = (ArrayList) pagedCourtResponse.getValue();
                        System.out.println("arr promo home " + arrFavHome);
                        CourtFavouriteAdapter courtFavAdapter = new CourtFavouriteAdapter(HomeActivity.this, arrFavHome);
                        // set adapter
                        viewFavCourt.setLayoutManager(mLayoutFavourite);
                        viewFavCourt.setAdapter(courtFavAdapter);
                        courtFavAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<PagedCourtResponse> call, Throwable t) {

                }
            });
    }

    // call api court size
    public void callSize() {
        CourtSizeRequest paramsRequest = new CourtSizeRequest();
        paramsRequest.setCurrentPage(1);
        paramsRequest.setVendorId(11);
        paramsRequest.setQueryString("");
        paramsRequest.setPageSize(10);

        Call<CourtSizeResponse> pagedSizeResponse = ApiClient.getCourtSizeService().getSize(AUTHORIZATION, paramsRequest.getVendorId(), paramsRequest.getPageSize(), paramsRequest.getQueryString(), paramsRequest.getCurrentPage());
        pagedSizeResponse.enqueue(new Callback<CourtSizeResponse>() {
            @Override
            public void onResponse(Call<CourtSizeResponse> call, Response<CourtSizeResponse> response) {
                if (response.code() == 200) {
                    CourtSizeResponse courtSizeResponse = response.body();
                    arrSizeResponse = (ArrayList<CourtSizeValue>) courtSizeResponse.getValue();
                    String status = "size";
                    System.out.println(" call size " + arrSizeResponse.size());
                }
            }

            @Override
            public void onFailure(Call<CourtSizeResponse> call, Throwable t) {

            }
        });
    }

}