package com.example.tennis_booking_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.Booking.BookingValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.ViewModels.Booking.BookingRequest;
import com.example.tennis_booking_app.ViewModels.Booking.BookingRespone;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichSu extends AppCompatActivity {
    ListView lvHis;
    Token TOKEN;
    String AUTHORIZATION;
    ArrayList<BookingValue> arrBooking;

    //ArrayList<History> arrHis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su);
        lvHis = (ListView) findViewById(R.id.lvLichsu);
        /*arrHis=new ArrayList<>();
        arrHis.add(new History(R.drawable.tennis,"Sân 1A","Slot 7: 17:45-19:15","2/4/2022, 8:34","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Cộng Hòa Tennis","Slot 2: 8:45-10:15","4/4/2022, 10:00","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Thủ Thiêm","Slot 7: 17:00 - 18:30","2/4/2022, 8:34","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Thủ Đức Tennis","Slot 7: 17:00 - 18:30","2/4/2022, 8:34","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Thủ Đức Tennis","Slot 7: 17:00 - 18:30","2/4/2022, 8:34","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Sa Sa Tennis","Slot 7: 17:00 - 18:30","20/4/2022, 8:34","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Kim Sa","Slot 7: 17:00 - 18:30","2/4/2022, 8:34","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Hoàng Sa Tennis","Slot 7: 17:00 - 18:30","2/4/2022, 8:34","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Trường Sa Tennis","Slot 7: 17:00 - 18:30","2/4/2022, 8:34","150,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Kim Tennis","Slot 7: 17:00 - 18:30","2/4/2022, 8:34","150,000vnd"));


        adapter=new LichSuAdapter(this,R.layout.list_history,arrHis);
        lvHis.setAdapter(adapter);

        lvHis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LichSu.this, DetailActivity.class);
                History san = arrHis.get(position);
                intent.putExtra("detailBooking", (Serializable) san);
                startActivity(intent);
            }
        });*/

        //get sharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sh.getString("TOKEN","");
        TOKEN = gson.fromJson(json,Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();
        LoadBooking();
    }

    private void LoadBooking() {
        BookingRequest param_request = new BookingRequest();
        param_request.setVendorId(11);
        param_request.setPageSize(10);
        param_request.setQueryString("");
        param_request.setCurrentPage(1);

        Call<BookingRespone> bookingResponeCall = ApiClient.getBookingService().getBooking(AUTHORIZATION, param_request.getVendorId(), param_request.getPageSize(), param_request.getQueryString(), param_request.getCurrentPage());
        bookingResponeCall.enqueue(new Callback<BookingRespone>() {
            @Override
            public void onResponse(Call<BookingRespone> call, Response<BookingRespone> response) {
                if (response.body() != null){
                    arrBooking=new ArrayList<>();
                    BookingRespone bookingRespone=response.body();
                    arrBooking = (ArrayList) bookingRespone.getValue();
                    LichSuAdapter adapter=new LichSuAdapter(LichSu.this,R.layout.list_history,arrBooking);
                    lvHis.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<BookingRespone> call, Throwable t) {

            }
        });
    }
}