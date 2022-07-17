package com.example.tennis_booking_app.PhucHLH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tennis_booking_app.DetailsPromotion;
import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.SanAdapter;
import com.example.tennis_booking_app.SanTennis;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.example.tennis_booking_app.ViewModels.PagedCourtByType.PagedCourtTypeRespone;
import com.example.tennis_booking_app.ViewModels.PagedCourtByType.PagedCoutTypeRequest;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecificCourtsActivity extends AppCompatActivity {

    TextView txtType;
    ListView lvSpecific;
    ArrayList<SanTennis> arrSan, arrSearch;
    Adapter sanAdapter;
    String noiDung = null;
    List<PagedCourtResponse> arrPagedCourtResponses;
    Token TOKEN;
    String AUTHORIZATION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_courts);

        arrPagedCourtResponses = new ArrayList<>();
        txtType = findViewById(R.id.txtType);
        lvSpecific = (ListView) findViewById(R.id.lvSpecificCourt);
        arrSearch = new ArrayList<>();

        //get sharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sh.getString("TOKEN","");
        TOKEN = gson.fromJson(json,Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();

        AnhXa();

        lvSpecific.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SpecificCourtsActivity.this, DetailsPromotion.class);
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
        if (noiDung.equals("Sân đất nện")) {
            /*arrSan.add(new SanTennis("Sân đất nện", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_clay, "4.3km", "4.2"));
            arrSan.add(new SanTennis("Sân đất nện", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_clay, "4.3km", "4.2"));
            arrSan.add(new SanTennis("Sân đất nện", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_clay, "4.3km", "4.2"));
            arrSan.add(new SanTennis("Sân đất nện", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_clay, "4.3km", "4.2"));
            arrSan.add(new SanTennis("Sân đất nện", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_clay, "4.3km", "4.2"));
            arrSan.add(new SanTennis("Sân đất nện", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_clay, "4.3km", "4.2"));
            sanAdapter = new SanAdapter(this, R.layout.list_court_near, arrSan);
            lvSpecific.setAdapter((ListAdapter) sanAdapter);*/
            LoadCourtType(2);
            txtType.setText("Sân đất nện");
        } else if (noiDung.equals("Sân cứng")) {
           /* arrSan.add(new SanTennis("Sân cứng", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_hard, "3 km", "4.2"));
            arrSan.add(new SanTennis("Sân cứng", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_hard, "9.1 km", "4.2"));
            arrSan.add(new SanTennis("Sân cứng", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_hard, "4.9 km", "4.2"));
            arrSan.add(new SanTennis("Sân cứng", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_hard, "4 km", "4.2"));
            arrSan.add(new SanTennis("Sân cứng", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_hard, "3 km", "4.2"));
            arrSan.add(new SanTennis("Sân cứng", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_hard, "6.1 km", "4.2"));
            arrSan.add(new SanTennis("Sân cứng", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_hard, "1 km", "4.2"));
            sanAdapter = new SanAdapter(this, R.layout.list_court_near, arrSan);
            lvSpecific.setAdapter((ListAdapter) sanAdapter);*/
            LoadCourtType(3);
            txtType.setText("Sân cứng");
        } else if (noiDung.equals("Sân cỏ")) {
            /*arrSan.add(new SanTennis("Sân cỏ", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_grass, "500 m", "4.2"));
            arrSan.add(new SanTennis("Sân cỏ", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_grass, "2.2 km", "4.2"));
            arrSan.add(new SanTennis("Sân cỏ", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_grass, "4.3 km", "4.2"));
            arrSan.add(new SanTennis("Sân cỏ", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_grass, "4.5 km", "4.2"));
            arrSan.add(new SanTennis("Sân cỏ", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_grass, "9 km", "4.2"));
            arrSan.add(new SanTennis("Sân cỏ", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_grass, "4 km", "4.2"));
            arrSan.add(new SanTennis("Sân cỏ", "36.57m x 18.29m", "150.000 vnđ ~ 300.000 vnđ", R.drawable.ic_grass, "8.4 km", "4.2"));
            sanAdapter = new SanAdapter(this, R.layout.list_court_near, arrSan);
            lvSpecific.setAdapter((ListAdapter) sanAdapter);*/

            LoadCourtType(1);
            txtType.setText("Sân cỏ");
        }
        else if (noiDung.equals("UD")) {
            loadPromoCourt();
            txtType.setText("Sân đang có ưu đãi");
        }
        else if (noiDung.equals("Gần tôi")) {
            arrSan.add(new SanTennis("CLB Tennis Linh Trung", "36.57m x 18.29m", "100.000 - 300.000 đồng", R.drawable.imgtennis1, "3 km", "4.2"));
            arrSan.add(new SanTennis("Tennis Hoàng Diệu", "36.57m x 18.29m", "100.000 - 300.000 đồng", R.drawable.imgtennis2, "9.1 km", "4.2"));
            arrSan.add(new SanTennis("Sân Biên Hòa", "36.57m x 18.29m", "100.000 - 300.000 đồng", R.drawable.imgtennis1, "7.9 km", "4.2"));
            arrSan.add(new SanTennis("Sân Cát Lái", "36.57m x 18.29m", "100.000 - 300.000 đồng", R.drawable.imgtennis3, "4 km", "4.2"));
            arrSan.add(new SanTennis("Sân Suối Tiên 1", "36.57m x 18.29m", "100.000 - 300.000 đồng", R.drawable.imgtennis1, "3 km", "4.2"));
            arrSan.add(new SanTennis("Sân Suối Tiên 2", "36.57m x 18.29m", "100.000 - 300.000 đồng", R.drawable.imgtennis1, "3 km", "4.2"));
            arrSan.add(new SanTennis("Sân Vinhomes", "36.57m x 18.29m", "100.000 - 300.000 đồng", R.drawable.ic_hard, "4 km", "4.2"));
        } else if (noiDung.equals("Gần tôi")) {
            arrSan.add(new SanTennis("CLB Tennis Linh Trung", "36.57m x 18.29m", "100.000 vnđ - 300.000 đồng", R.drawable.imgtennis1, "3 km", "4.2"));
            arrSan.add(new SanTennis("Tennis Hoàng Diệu", "36.57m x 18.29m", "100.000 vnđ - 300.000 đồng", R.drawable.imgtennis2, "9.1 km", "4.2"));
            arrSan.add(new SanTennis("Sân Biên Hòa", "36.57m x 18.29m", "100.000 vnđ - 300.000 đồng", R.drawable.imgtennis1, "7.9 km", "4.2"));
            arrSan.add(new SanTennis("Sân Cát Lái", "36.57m x 18.29m", "100.000 vnđ - 300.000 đồng", R.drawable.imgtennis3, "4 km", "4.2"));
            arrSan.add(new SanTennis("Sân Suối Tiên 1", "36.57m x 18.29m", "100.000 vnđ - 300.000 đồng", R.drawable.imgtennis1, "3 km", "4.2"));
            arrSan.add(new SanTennis("Sân Suối Tiên 2", "36.57m x 18.29m", "100.000 vnđ - 300.000 đồng", R.drawable.imgtennis1, "3 km", "4.2"));
            arrSan.add(new SanTennis("Sân Vinhomes", "36.57m x 18.29m", "100.000 vnđ - 300.000 đồng", R.drawable.ic_hard, "4 km", "4.2"));
            sanAdapter = new SanAdapter(this, R.layout.list_court_near, arrSan);
            lvSpecific.setAdapter((ListAdapter) sanAdapter);
        }
        else {
            arrSan.add(new SanTennis("Sân Hoàng Văn Thụ", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "19km", "4.2"));
            arrSan.add(new SanTennis("Sân Cỏ nhân tạo quận 3", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "12km", "4.2"));
            arrSan.add(new SanTennis("Sân Lê Thị Riêng", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "20km", "4.2"));
            arrSan.add(new SanTennis("Sân Đồng Nai", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "9km", "4.2"));
            arrSan.add(new SanTennis("Sân Thủ Đức", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "2km", "4.2"));
            arrSan.add(new SanTennis("Sân Hóc Môn", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "30km", "4.2"));
            arrSan.add(new SanTennis("Sân Suối Tiên", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "7km", "4.2"));
            arrSan.add(new SanTennis("Sân Suối Tiên 2", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "8km", "4.2"));
            arrSan.add(new SanTennis("Sân 399", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "1km", "4.2"));
            arrSan.add(new SanTennis("Sân Quận 12", "36.57m x 18.29m", "100.000 đồng", R.drawable.san2a, "21km", "4.2"));
            for (int i = 0; i < arrSan.size(); i++) {
                if ((arrSan.get(i).getTen().toLowerCase().contains(noiDung.toLowerCase()))) {
                    arrSearch.add(arrSan.get(i));
                    sanAdapter = new SanAdapter(this, R.layout.list_court_near, arrSearch);
                    lvSpecific.setAdapter((ListAdapter) sanAdapter);
                }
            }
        }
    }

    private void loadPromoCourt() {
        PagedCourtRequest param_request = new PagedCourtRequest();
        param_request.setPageSize(5);
        param_request.setVendorID(11);
        param_request.setQueryString("");
        param_request.setCurrentPage(1);


        Call<PagedCourtResponse> pagedCourtResponseCall = ApiClient.getVendorService().getPagedPromoCourt(AUTHORIZATION,param_request.getVendorID(), param_request.getPageSize(), param_request.getQueryString(), param_request.getCurrentPage());
        System.out.println("request url \n" + pagedCourtResponseCall.request().url());

        pagedCourtResponseCall.enqueue(new Callback<PagedCourtResponse>() {
            @Override
            public void onResponse(Call<PagedCourtResponse> call, Response<PagedCourtResponse> response) {
                if(response.body() != null) {
                    System.out.println("body: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PagedCourtResponse> call, Throwable t) {

            }
        });

    }

    private void LoadCourtType(int id){
        PagedCoutTypeRequest param_request= new PagedCoutTypeRequest();
        param_request.setPageSize(5);
        param_request.setVendorID(11);
        param_request.setQueryString("");
        param_request.setCurrentPage(1);

        Call<PagedCourtTypeRespone> pagedCourtTypeResponeCall=ApiClient.getVendorService().getPagedType(AUTHORIZATION,param_request.getVendorID(), param_request.getPageSize(), param_request.getQueryString(), param_request.getCurrentPage(),id);
        System.out.println("request url \n" + pagedCourtTypeResponeCall.request().url());

        pagedCourtTypeResponeCall.enqueue(new Callback<PagedCourtTypeRespone>() {
            @Override
            public void onResponse(Call<PagedCourtTypeRespone> call, Response<PagedCourtTypeRespone> response) {
                if(response.body() != null) {
                    System.out.println("body: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PagedCourtTypeRespone> call, Throwable t) {

            }
        });

    }

}
