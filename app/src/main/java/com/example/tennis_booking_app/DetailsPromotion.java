package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailsPromotion extends AppCompatActivity {
    ListView lvSanKM;
    SanKmAdapter adapter;
    ArrayList<SanKM> arrSanKM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_promotion);

        lvSanKM=(ListView) findViewById(R.id.lvSanKM);
        arrSanKM=new ArrayList<>();

        arrSanKM.add(new SanKM("Sân 1A - Sân đất nện","36.57m x 18.29m","70.000 - 300.000 vnđ",R.drawable.san1a));
        arrSanKM.add(new SanKM("Sân 2A - Sân PVC","36.57m x 18.29m","100.000 - 350.000 vnđ",R.drawable.san2a));
        arrSanKM.add(new SanKM("Sân 2B - Sân cỏ","36.57m x 18.29m","150.00 - 400.000 vnđ",R.drawable.san2b));

        adapter=new SanKmAdapter(this,R.layout.list_san_promo,arrSanKM);
        lvSanKM.setAdapter(adapter);

        lvSanKM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}