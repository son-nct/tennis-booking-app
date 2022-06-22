package com.example.tennis_booking_app;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class KhuyenMai extends AppCompatActivity {

    ListView lvKhuyenmai;
    PromoAdapter adapter;
    ArrayList<Promo> arrPromo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khuyen_mai);
        lvKhuyenmai=(ListView) findViewById(R.id.lvKhuyenMai);
        arrPromo=new ArrayList<>();
        arrPromo.add(new Promo("LANDAUDAT","Khuyến mãi lần đầu đặt","50,000vnd",R.drawable.promo));
        arrPromo.add(new Promo("CUOITUAN","khuyến mãi cuối tuần","50,000vnd",R.drawable.promo));
        arrPromo.add(new Promo("NGAYLEDACBIET","Khuyến mãi ngày lế","50,000vnd",R.drawable.promo));

        adapter=new PromoAdapter(this,R.layout.list_promo,arrPromo);
        lvKhuyenmai.setAdapter(adapter);

        /*lvKhuyenmai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(KhuyenMai.this,ConfirmBooking.class);
                startActivity(intent);
            }
        });*/

    }
}