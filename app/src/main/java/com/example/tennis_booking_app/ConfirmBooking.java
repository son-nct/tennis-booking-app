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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.Models.Voucher;
import com.example.tennis_booking_app.PhucHLH.CourtDiscountHorizontalAdapter;
import com.example.tennis_booking_app.ViewModels.Slot.SlotRespone;
import com.example.tennis_booking_app.ViewModels.Voucher.VoucherRequest;
import com.example.tennis_booking_app.ViewModels.Voucher.VoucherResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmBooking extends AppCompatActivity {
    TextView txtVendorID, txtCourtName, txtDientich2,
            txtSlot, txtGia, txtNgay, txtThanhGia, txtTongGia;
    TextView edtPromo;
    Button btNhan, btKM1, btKM2, btKM3;
    Intent intent1, intentKM, intentConfirm, intentValue, intentVoucher;
    ArrayList<SlotRespone> arrSelected;
    int sum=0;
    PagedCourtValue courtValue;
    List<Voucher> arrVoucher;
    Token TOKEN;
    String AUTHORIZATION;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        txtVendorID = (TextView) findViewById(R.id.txtVendorID);
        txtCourtName = (TextView) findViewById(R.id.txtCourtName);
        txtDientich2 = (TextView) findViewById(R.id.txtDientich2);
        txtSlot = (TextView) findViewById(R.id.txtSlot);
        txtGia = (TextView) findViewById(R.id.txtGia);
        txtThanhGia = (TextView) findViewById(R.id.txtThanhGia);
        txtTongGia = (TextView) findViewById(R.id.txtTongGia);
        txtNgay = (TextView) findViewById(R.id.txtNgay);
        edtPromo = (TextView) findViewById(R.id.edtPromo);
        btNhan = (Button) findViewById(R.id.btNhan);


        intent1 = getIntent();
        intentKM = getIntent();
        intentValue = getIntent();
        intentVoucher = getIntent();

        //SanTennis ten2 = (SanTennis) intent1.getSerializableExtra("sandetail2");
//        SanKM tenKM = (SanKM) intentKM.getSerializableExtra("sandetailKM");

        intentConfirm = getIntent();
        Bundle bundle = intentConfirm.getBundleExtra("data");
        arrSelected = (ArrayList<SlotRespone>) bundle.getSerializable("arrSlotSelected");
        courtValue = (PagedCourtValue) bundle.getSerializable("courtValue");


        loadVoucher(courtValue.getVendorId());

        //get sharedPreference
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sharedPreferences.getString("TOKEN", "");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();


       /* if (ten2 != null) {
            CaChoi caChoi2 = (CaChoi) intent1.getSerializableExtra("cadetail");
            String d = bundle.getString("date");
            txtTennis2.setText(ten2.getTen());
            txtTennis21.setText(ten2.getTen());
            txtDientich2.setText(ten2.getDientich());
            if (arrSelected.size() > 0) {
                int sum=0;
                for (CaChoi caChoi : arrSelected) {
                    txtSlot.setText(caChoi.getThoiluong() + ", ");
                    txtGia.setText(caChoi.getGia() + ", ");
                    txtGia2.setText(caChoi.getGia() + ", ");
                    sum+= Integer.parseInt(caChoi.getGia());
                    txtTong.setText(sum);
                }
            }

            txtNgay.setText(d);
        }*/

        if (courtValue != null) {
            txtVendorID.setText(courtValue.getName());
            txtCourtName.setText(courtValue.getName());
//            txtDientich2.setText(courtValue.getDientich());
            if (arrSelected.size() > 0) {
                String selected_slot = "";
                String selected_slot_price = "";

                for (SlotRespone caChoi : arrSelected) {
                    selected_slot += caChoi.getStartTime()+ ", ";
                    selected_slot_price += caChoi.getPrice()+ ", ";
                    sum += Integer.parseInt(caChoi.getPrice()+ "");

                }

                txtSlot.setText(selected_slot);
                txtGia.setText(selected_slot_price);
                txtThanhGia.setText(sum+" vnđ");
                txtTongGia.setText(sum+" vnđ");
            }
            txtNgay.setText("");
        }

        edtPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDialogKM();
            }
        });


//        btNhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent1 = new Intent(ConfirmBooking.this, ChucMung.class);
//                startActivity(intent1);
//            }
//        });

    }

    private void loadDialogKM() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_khuyen_mai);
        dialog.setCanceledOnTouchOutside(true);
//        btKM1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edtPromo.setText("NGUOIQUEN");
//                int total = sum - 20000;
//                txtTongGia.setText(total+" vnđ");
//                dialog.dismiss();
//            }
//        });
//        btKM2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edtPromo.setText("CUOITUAN");
//                int total = sum - 30000;
//                txtTongGia.setText(total+" vnđ");
//                dialog.dismiss();
//            }
//        });
//        btKM3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edtPromo.setText("LANDAU");
//                int total = sum - 50000;
//                txtTongGia.setText(total+" vnđ");
//                dialog.dismiss();
//            }
//        });
        dialog.show();
    }

    private void loadVoucher(int vendorID){
        VoucherRequest paramsRequest = new VoucherRequest();
        paramsRequest.setVendorId(vendorID);

        Call<VoucherResponse> vendorResponseCall = ApiClient.getVoucherService().getPagedVoucher(AUTHORIZATION, paramsRequest.getVendorId());
        vendorResponseCall.enqueue(new Callback<VoucherResponse>() {
            @Override
            public void onResponse(Call<VoucherResponse> call, Response<VoucherResponse> response) {
                if(response.body() !=null){
                    // handle API
                    arrVoucher = response.body().getValue();
                    System.out.println("voucher value " + arrVoucher);
                    DialogVoucherAdapter voucherAdapter = new DialogVoucherAdapter(ConfirmBooking.this, arrVoucher, sharedPreferences);

                }
            }

            @Override
            public void onFailure(Call<VoucherResponse> call, Throwable t) {

            }
        });
    }
}