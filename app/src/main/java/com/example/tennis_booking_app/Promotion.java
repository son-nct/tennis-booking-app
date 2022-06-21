package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Promotion extends AppCompatActivity {
    RecyclerView rvPromo;
    ArrayList<PromoClass> arrPromo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        rvPromo=(RecyclerView) findViewById(R.id.rvPromo);
        arrPromo=new ArrayList<>();

        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                        "Promo","Sân Q9-Kim Sa","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Q7-Hoàng Sa","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Q7-Trường Sa","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Q9-Châu Sa","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Thủ Đức-Lam Sơn","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Thủ Đức-Nhật Tân","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Gò Vấp-Gia Định","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Gò Vấp-Nam Hà","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Q2-Đa màu","1km-4.8","REVLRA"));
        arrPromo.add(new PromoClass(R.drawable.imgtennis1,R.drawable.ic_star_svgrepo_com,R.drawable.discount,
                "Promo","Sân Q2-Chiến Thắng","1km-4.8","REVLRA"));

        PromoAdapter adapter=new PromoAdapter(arrPromo);
        rvPromo.setAdapter(adapter);
        rvPromo.setLayoutManager(new LinearLayoutManager(this));
    }
}