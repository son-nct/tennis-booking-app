package com.example.tennis_booking_app;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.BookingDetail.BookingDetailRequest;
import com.example.tennis_booking_app.Models.BookingDetail.BookingDetailRespone;
import com.example.tennis_booking_app.Models.Token;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConfirmBooking extends AppCompatActivity {
    TextView txtTennis2, txtTennis21, txtDientich2, txtNote,
            txtSlot, txtGia, txtNgay, txtGia2, txtTong;
    TextView edtPromo;
    Button btNhan, btKM1, btKM2, btKM3;
    Intent intent1, intentKM;
    ArrayList<CaChoi> arrSelected;
    int sum = 0;
    Token TOKEN;
    String AUTHORIZATION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        txtTennis2 = (TextView) findViewById(R.id.txtTennis2);
        txtTennis21 = (TextView) findViewById(R.id.txtTennis21);
        txtDientich2 = (TextView) findViewById(R.id.txtDientich2);
        txtSlot = (TextView) findViewById(R.id.txtSlot);
        txtGia = (TextView) findViewById(R.id.txtGia);
        txtGia2 = (TextView) findViewById(R.id.txtGia2);
        txtTong = (TextView) findViewById(R.id.txtTong);
        txtNgay = (TextView) findViewById(R.id.txtNgay);
        edtPromo = (TextView) findViewById(R.id.edtPromo);
        btNhan = (Button) findViewById(R.id.btNhan);


        intent1 = getIntent();
        intentKM = getIntent();

        //get sharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sh.getString("TOKEN","");
        TOKEN = gson.fromJson(json,Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();

        //SanTennis ten2 = (SanTennis) intent1.getSerializableExtra("sandetail2");
        SanKM tenKM = (SanKM) intentKM.getSerializableExtra("sandetailKM");
        Bundle bundle = intent1.getBundleExtra("data");
        arrSelected = (ArrayList<CaChoi>) bundle.getSerializable("arrSlotSelected");


        if (tenKM != null) {
            String d = bundle.getString("date");
            txtTennis2.setText(tenKM.getTen());
            txtTennis21.setText(tenKM.getTen());
            txtDientich2.setText(tenKM.getDientich());
            if (arrSelected.size() > 0) {
                String selected_slot = "";
                String selected_slot_price = "";

                for (CaChoi caChoi : arrSelected) {
                    selected_slot += caChoi.getSlot() + ", ";
                    selected_slot_price += caChoi.getThoiluong() + ", ";
                    sum += Integer.parseInt(caChoi.getGia());

                }

                txtSlot.setText(selected_slot);
                txtGia.setText(selected_slot_price);
                txtGia2.setText(sum + " vnđ");
                txtTong.setText(sum + " vnđ");
                System.out.println("price : " + sum);
            }

            txtNgay.setText(d);
        }

        edtPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogKM();
            }
        });


        btNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1 = new Intent(ConfirmBooking.this, ChucMung.class);
                startActivity(intent1);
            }
        });

    }

    private void DialogKM() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_khuyen_mai);
        dialog.setCanceledOnTouchOutside(false);
        btKM1 = (Button) dialog.findViewById(R.id.btKM1);
        btKM2 = (Button) dialog.findViewById(R.id.btKM2);
        btKM3 = (Button) dialog.findViewById(R.id.btKM3);
        btKM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPromo.setText("NGUOIQUEN");
                int total = sum - 20000;
                txtTong.setText(total + " vnđ");
                dialog.dismiss();
            }
        });
        btKM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPromo.setText("CUOITUAN");
                int total = sum - 30000;
                txtTong.setText(total + " vnđ");
                dialog.dismiss();
            }
        });
        btKM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPromo.setText("LANDAU");
                int total = sum - 50000;
                txtTong.setText(total + " vnđ");
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void LoadConfirmBooing(){
        BookingDetailRequest bookingDetailRequest=new BookingDetailRequest();
        bookingDetailRequest.setId(1);

        Call<BookingDetailRespone> bookingDetailResponeCall= ApiClient.getBookingDetailService().getBookingDetail(AUTHORIZATION,bookingDetailRequest.getId());
        System.out.println("request url \n" + bookingDetailResponeCall.request().url());

        bookingDetailResponeCall.enqueue(new Callback<BookingDetailRespone>() {
            @Override
            public void onResponse(Call<BookingDetailRespone> call, Response<BookingDetailRespone> response) {
                if(response.body() != null) {
                    System.out.println("body: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<BookingDetailRespone> call, Throwable t) {

            }
        });
    }
}