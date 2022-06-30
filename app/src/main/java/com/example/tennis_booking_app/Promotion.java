package com.example.tennis_booking_app;

import static com.example.tennis_booking_app.R.drawable.discount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Promotion extends AppCompatActivity {
    RecyclerView rvPromo;
    ArrayList<PromoClass> arrPromo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        rvPromo=(RecyclerView) findViewById(R.id.rvPromo);
        arrPromo=new ArrayList<>();

        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com,R.drawable.discount, R.drawable.discount,
                "Promo","Sân Q9 - Kim Sa","1 km - 4.8","Nhập mã XEODLT41 g...","Discounted items"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com,R.drawable.discount, R.drawable.discount,
                "Promo","Sân Q7 - Hoàng Sa","15 km  - 4.8","Nhập mã BAORE40K g...","Discount items"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com, R.drawable.discount, R.drawable.discount,
                "Promo","Sân Q9 - Hải Sa","2 km - 4.8","Ưu đãi đến 45k","Discounted items"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com,R.drawable.discount,R.drawable.discount,
                "Promo","Sân Thủ Đức - Sa Sa","2 km - 4.8","Ưu đãi đến 45k","Discounted items"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com, R.drawable.discount,R.drawable.discount,
                "Promo","Sân Thủ Đức - Sơn Sa","1.2 km - 4.8","Deal khủng chỉ 10k","5%off"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com, R.drawable.discount,R.drawable.discount,
                "Promo","Sân Gò Vấp - Gia Định","6 km - 4.8","Chỉ trên Tennis App...","Discounted items"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com,R.drawable.discount,R.drawable.discount,
                "Promo","Thủ Đức -Gia Định","1 km - 4.8","Ưu đãi 10k","10%off"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com,R.drawable.discount,R.drawable.discount,
                "Promo","Sân Gò Vấp-Nam Hà","2.5 km - 4.8","Chỉ có trên Tennis App...","15%off"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com, R.drawable.discount, R.drawable.discount,
                "Promo","Sân Q2-Đa màu","5 km - 4.8","Ưu đãi đến 30k","Discounted items"));
        arrPromo.add(new PromoClass(R.drawable.imghinhsan,R.drawable.ic_star_svgrepo_com, R.drawable.discount, R.drawable.discount,
                "Promo","Sân Q2-Chiến Thắng","5.6 km - 4.8","Deal khủng chỉ 30k","Discounted items"));

        PromoAdapter adapter=new PromoAdapter(this,arrPromo);
        rvPromo.setAdapter(adapter);
        rvPromo.setLayoutManager(new LinearLayoutManager(this));

    }
}