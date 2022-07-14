package com.example.tennis_booking_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tennis_booking_app.PhucHLH.CourtDiscount;
import com.example.tennis_booking_app.PhucHLH.CourtDiscountHorizontalAdapter;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetailsPromotion extends AppCompatActivity {
    ListView lvSanKM;
    SanKmAdapter adapter;
    //    EditText edtCourtName;
    ArrayList<SanKM> arrSanKM;
    //    TextView txtRatingnReview;
    TextView txtRating;

    RecyclerView viewCourtPromo;
    RecyclerView viewPromoCourt;
    CourtDiscountHorizontalAdapter courtDiscountHorizontalAdapter;
    List<CourtDiscount> arrCourtDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_promotion);

        lvSanKM = (ListView) findViewById(R.id.lvSanKM);
//        edtCourtName.setEnabled(false);
        arrSanKM = new ArrayList<>();
        txtRating = findViewById(R.id.txtRatingAndComment);
        viewCourtPromo = findViewById(R.id.viewCourtPromo);

        // horizontal view promo
        viewPromoCourt = (RecyclerView) findViewById(R.id.viewCourtPromo);
        arrCourtDiscount = new ArrayList<>();
        courtDiscountHorizontalAdapter = new CourtDiscountHorizontalAdapter(arrCourtDiscount, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewPromoCourt.setLayoutManager(mLayoutManager);
        viewPromoCourt.setItemAnimator(new DefaultItemAnimator());
        viewPromoCourt.setAdapter(courtDiscountHorizontalAdapter);
        initdata();

        // end of horizontal view promo

        arrSanKM = new ArrayList<>();

        arrSanKM.add(new SanKM("Sân 1A - Sân đất nện", "36.57m x 18.29m", "150.000 - 200.000 đ", "TENNIS10", R.drawable.tennis_clay, "5", "4.3"));
        arrSanKM.add(new SanKM("Sân 2A - Sân PVC", "36.57m x 18.29m", "150.000 - 250.000 đ", "TENNIS10", R.drawable.tennis_grass, "4.6", "4.3"));
        arrSanKM.add(new SanKM("Sân 2B - Sân cỏ", "36.57m x 18.29m", "150.000 - 300.000 đ", "TENNIS10", R.drawable.tennis_grass, "5", "4.3"));

        adapter = new SanKmAdapter(this, R.layout.list_san_promo, arrSanKM);
        lvSanKM.setAdapter(adapter);

//        txtRatingnReview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DetailsPromotion.this, DanhGia.class);
//                startActivity(intent);
//            }
//        });
        txtRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsPromotion.this, DanhGia.class);
                startActivity(intent);
            }
        });

        lvSanKM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanKM sanKM = arrSanKM.get(position);
                Intent intent = new Intent(DetailsPromotion.this, Booking.class);
                intent.putExtra("sanKMDetail", (Serializable) sanKM);
                startActivity(intent);
            }
        });


    }

    private void initdata() {
        arrCourtDiscount.add(new CourtDiscount("Khách Quen Thân Yêu", "Giảm 20.000đ", R.drawable.tennis_clay, "Nhập mã KHACHQUEN để được ưu đãi 20.000đ khi đặt sân từ 3 lần trở lên"));
        arrCourtDiscount.add(new CourtDiscount("Cuối Tuần Vui Vẻ", "Giảm 30.000đ", R.drawable.tennis_grass, "Nhập mã CUOITUAN để được ưu đãi 30.000đ khi đặt sân vào T7 & Chủ Nhật"));
        arrCourtDiscount.add(new CourtDiscount("Mời bạn Lần Đầu", "Giảm 50.000đ", R.drawable.tennis_grass, "Nhập mã LANDAU để được ưu đãi 50.000đ khi đặt sân lần đầu"));
        courtDiscountHorizontalAdapter.notifyDataSetChanged();
    }
}