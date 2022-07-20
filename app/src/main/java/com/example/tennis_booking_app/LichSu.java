package com.example.tennis_booking_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.Booking.BookingValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.ViewModels.BookingHistory.BookingHistoryRequest;
import com.example.tennis_booking_app.ViewModels.BookingHistory.BookingHistoryResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichSu extends AppCompatActivity {
    ListView lvHis;
    Token TOKEN;
    String AUTHORIZATION;
    ArrayList<BookingValue> arrBooking;
    SharedPreferences sh;

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
        sh = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sh.getString("TOKEN","");
        TOKEN = gson.fromJson(json,Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();
        LoadBooking();
    }

    private void LoadBooking() {
        BookingHistoryRequest param_request = new BookingHistoryRequest();
        param_request.setVendorId(520);
        param_request.setPageSize(30);
        param_request.setQueryString("");
        param_request.setCurrentPage(1);

        Call<BookingHistoryResponse> bookingResponeCall = ApiClient.getBookingService().getBooking(AUTHORIZATION, param_request.getVendorId(), param_request.getPageSize(), param_request.getQueryString(), param_request.getCurrentPage());
        bookingResponeCall.enqueue(new Callback<BookingHistoryResponse>() {
            @Override
            public void onResponse(Call<BookingHistoryResponse> call, Response<BookingHistoryResponse> response) {
                if (response.body() != null){
                    arrBooking=new ArrayList<>();
                    BookingHistoryResponse bookingRespone=response.body();
                    arrBooking = (ArrayList) bookingRespone.getValue();
                    LichSuAdapter adapter=new LichSuAdapter(LichSu.this,sh,arrBooking);
                    lvHis.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<BookingHistoryResponse> call, Throwable t) {

            }
        });
    }
}