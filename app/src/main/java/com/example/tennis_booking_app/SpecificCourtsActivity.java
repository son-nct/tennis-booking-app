package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class SpecificCourtsActivity extends AppCompatActivity {

    TextView txtType;
    ListView lvSpecific;
    ArrayList<SanTennis> arrSan, arrSearch;
    Adapter sanAdapter;
    String noiDung = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_courts);

        txtType = findViewById(R.id.txtType);
        lvSpecific = (ListView) findViewById(R.id.lvSpecificCourt);
        arrSearch = new ArrayList<>();
        AnhXa();

        lvSpecific.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SpecificCourtsActivity.this, YardDetail.class);
                SanTennis sanTennis = arrSan.get(position);
                intent.putExtra("sandetail", (Serializable) sanTennis);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        arrSan = new ArrayList<>();
        Intent intent = getIntent();
        noiDung = intent.getStringExtra("sandetail");
        txtType.setText(noiDung);
        if (noiDung.equals("Clay")) {
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay, "4.3 km"));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay, "4.3 km"));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay, "4.3 km"));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay, "4.3 km"));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay, "4.3 km"));
            arrSan.add(new SanTennis("Sân đất nện", "300m2", "150.000 đồng", R.drawable.ic_clay, "4.3 km"));
            sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
            lvSpecific.setAdapter((ListAdapter) sanAdapter);
        } else if (noiDung.equals("Hard")) {
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard, "3 km"));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard, "9.1 km"));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard, "4.9 km"));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard, "4 km"));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard, "3 km"));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard, "6.1 km"));
            arrSan.add(new SanTennis("Sân cứng", "300m2", "150.000 đồng", R.drawable.ic_hard, "1 km"));
            sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
            lvSpecific.setAdapter((ListAdapter) sanAdapter);
        } else if (noiDung.equals("Grass")) {
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass, "500 m"));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass, "2.2 km"));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass, "4.3 km"));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass, "4.5 km"));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass, "9 km"));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass, "4 km"));
            arrSan.add(new SanTennis("Sân cỏ", "300m2", "150.000 đồng", R.drawable.ic_grass, "8.4 km"));
            sanAdapter = new SanAdapter(this, R.layout.list_san, arrSan);
            lvSpecific.setAdapter((ListAdapter) sanAdapter);
        }else{
            arrSan.add(new SanTennis("Sân Hoàng Văn Thụ", "20m2", "100.000 đồng", R.drawable.san2a, "19km"));
            arrSan.add(new SanTennis("Sân Cỏ nhân tạo quận 3", "20m2", "100.000 đồng", R.drawable.san2a, "12km"));
            arrSan.add(new SanTennis("Sân Lê Thị Riêng", "20m2", "100.000 đồng", R.drawable.san2a, "20km"));
            arrSan.add(new SanTennis("Sân Đồng Nai", "20m2", "100.000 đồng", R.drawable.san2a, "9km"));
            arrSan.add(new SanTennis("Sân Thủ Đức", "20m2", "100.000 đồng", R.drawable.san2a, "2km"));
            arrSan.add(new SanTennis("Sân Hóc Môn", "20m2", "100.000 đồng", R.drawable.san2a, "30km"));
            arrSan.add(new SanTennis("Sân Suối Tiên", "20m2", "100.000 đồng", R.drawable.san2a, "7km"));
            arrSan.add(new SanTennis("Sân Suối Tiên 2", "20m2", "100.000 đồng", R.drawable.san2a, "8km"));
            arrSan.add(new SanTennis("Sân 399", "20m2", "100.000 đồng", R.drawable.san2a, "1km"));
            arrSan.add(new SanTennis("Sân Quận 12", "20m2", "100.000 đồng", R.drawable.san2a, "21km"));
            for (int i=0; i<arrSan.size(); i++){
                if((arrSan.get(i).getTen().toLowerCase().contains(noiDung.toLowerCase()))){
                    arrSearch.add(arrSan.get(i));
                    sanAdapter = new SanAdapter(this, R.layout.list_san, arrSearch);
                    lvSpecific.setAdapter((ListAdapter) sanAdapter);
                }
            }
        }
    }
}