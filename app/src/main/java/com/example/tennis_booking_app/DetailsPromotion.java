package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tennis_booking_app.PhucHLH.CourtDiscount;
import com.example.tennis_booking_app.PhucHLH.CourtDiscountHorizontalAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetailsPromotion extends AppCompatActivity {
    ListView lvSanKM;
    SanKmAdapter adapter;
    ArrayList<SanKM> arrSanKM;
    TextView txtRating;

    RecyclerView viewPromoCourt;
    CourtDiscountHorizontalAdapter courtDiscountHorizontalAdapter;
    List<CourtDiscount> arrCourtDiscount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_promotion);

        lvSanKM=(ListView) findViewById(R.id.lvSanKM);
        txtRating = findViewById(R.id.txtRatingAndComment);

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

        arrSanKM=new ArrayList<>();

        arrSanKM.add(new SanKM("Sân 1A - Sân đất nện","36.57m x 18.29m","70.000 - 300.000 đ" , "TENNIS10",R.drawable.tennis_clay, "5", "4.3"));
        arrSanKM.add(new SanKM("Sân 2A - Sân PVC","36.57m x 18.29m","100.000 - 350.000 đ", "TENNIS10",R.drawable.tennis_grass, "4.6","4.3"));
        arrSanKM.add(new SanKM("Sân 2B - Sân cỏ","36.57m x 18.29m","150.000 - 400.000 đ", "TENNIS10",R.drawable.tennis_grass, "5","4.3"));

        adapter=new SanKmAdapter(this,R.layout.list_san_promo,arrSanKM);
        lvSanKM.setAdapter(adapter);

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

    private void initdata(){
        arrCourtDiscount.add(new CourtDiscount("Sân đất nện", "170.000đ", "100.000đ", R.drawable.tennis_clay));
        arrCourtDiscount.add(new CourtDiscount("Sân cỏ 1A", "200.000đ", "150.000đ", R.drawable.tennis_grass));
        arrCourtDiscount.add(new CourtDiscount("Sân cỏ 2B", "180.000đ", "120.000đ", R.drawable.tennis_grass));
        arrCourtDiscount.add(new CourtDiscount("Sân cứng FPT", "130.000đ", "100.000đ", R.drawable.tennisq7));
        courtDiscountHorizontalAdapter.notifyDataSetChanged();
    }
}