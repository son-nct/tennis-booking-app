package com.example.tennis_booking_app;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.Models.Voucher;
import com.example.tennis_booking_app.ViewModels.Slot.SlotResponse;
import com.example.tennis_booking_app.ViewModels.Voucher.VoucherRequest;
import com.example.tennis_booking_app.ViewModels.Voucher.VoucherResponse;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmBooking extends AppCompatActivity {
    TextView txtVendorID, txtCourtName, txtDientich2,
            txtSlot, txtGia, txtNgay, txtThanhGia, txtTongGia, txtUuDai;
    TextView edtPromo;
    Button btNhan, btKM1, btKM2, btKM3;
    Intent intent1, intentKM, intentValue, intentVoucher;
    List<SlotResponse> arrSelected;
    int sum = 0;
    PagedCourtValue courtValue;
    List<Voucher> arrVoucher;
    Token TOKEN;
    String AUTHORIZATION;
    SharedPreferences sharedPreferences;
    ListView lvVoucher;
    TextView txtCourtNameHorizontalPromo, txtDiscount;
    Voucher voucherSelected;
    SharedPreferences shs;
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
        txtUuDai = (TextView) findViewById(R.id.txtUuDai);
        edtPromo = (TextView) findViewById(R.id.edtPromo);
        btNhan = (Button) findViewById(R.id.btNhan);


        intent1 = getIntent();
        intentKM = getIntent();
        intentValue = getIntent();
        intentVoucher = getIntent();

        //SanTennis ten2 = (SanTennis) intent1.getSerializableExtra("sandetail2");
//        SanKM tenKM = (SanKM) intentKM.getSerializableExtra("sandetailKM");

        Intent intentConfirm = getIntent();
        Bundle bundleConfirm = intentConfirm.getBundleExtra("data");
        arrSelected = (List<SlotResponse>) bundleConfirm.getSerializable("arrSlotSelected");
        courtValue = (PagedCourtValue) bundleConfirm.getSerializable("courtValue");


//        loadVoucher(courtValue.getVendorId());

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

                for (SlotResponse caChoi : arrSelected) {
                    selected_slot += caChoi.getStartTime() + ", ";
                    selected_slot_price += caChoi.getPrice() + ", ";
                    sum += Integer.parseInt(caChoi.getPrice() + "");

                }

                txtSlot.setText(selected_slot);
                txtGia.setText(selected_slot_price);
                txtThanhGia.setText(sum + " vnđ");
                txtTongGia.setText(sum + " vnđ");
            }
            txtNgay.setText("");
        }

        edtPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadVoucher(courtValue.getVendorId());
//                    Intent intentSelected = getIntent();
//                    Bundle bundleSelected = intentSelected.getBundleExtra("SelectData");
//                    voucherSelected = (Voucher) bundleSelected.getSerializable("PromoSelected");
//                    System.out.println("voucher selected "+ voucherSelected.getName());
//                    edtPromo.setText(voucherSelected.getName());

//                shs = getSharedPreferences("MySharedPref", 0);
//                Gson gson = new Gson();
//                String json = shs.getString("VOUCHER_SELECTED", "");
//                voucherSelected = gson.fromJson(json, Voucher.class);
//                edtPromo.setText(voucherSelected.getName());
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

    private void loadVoucher(int vendorID) {
        VoucherRequest paramsRequest = new VoucherRequest();
        paramsRequest.setVendorId(vendorID);

        Call<VoucherResponse> vendorResponseCall = ApiClient.getVoucherService().getPagedVoucher(AUTHORIZATION, paramsRequest.getVendorId());
        vendorResponseCall.enqueue(new Callback<VoucherResponse>() {
            @Override
            public void onResponse(Call<VoucherResponse> call, Response<VoucherResponse> response) {
                if (response.body() != null) {
                    arrVoucher = response.body().getValue();
                    Dialog dialog = new Dialog(ConfirmBooking.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_khuyen_mai);
                    dialog.setCanceledOnTouchOutside(true);
                    lvVoucher = dialog.findViewById(R.id.lvVoucher);
                    DialogVoucherAdapter voucherAdapter = new DialogVoucherAdapter(dialog.getContext(), arrVoucher, sharedPreferences);
                    lvVoucher.setAdapter(voucherAdapter);
                    lvVoucher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Voucher voucherClick = new Voucher();
                            voucherClick = arrVoucher.get(position);
                            System.out.println("voucher click = " + voucherClick);
                            edtPromo.setText(voucherClick.getName());
                            dialog.dismiss();
                            String gia = txtThanhGia.getText().toString().substring(0, txtThanhGia.getText().length()-3);
                            System.out.println("giaaaaaaaaaaaaaaaa " + gia);
                            int ketqua = Integer.parseInt(gia.trim()) - (voucherClick.getDiscountPrice());
                            txtUuDai.setText(String.valueOf(voucherClick.getDiscountPrice()));
                            txtTongGia.setText(String.valueOf(ketqua)+" vnd");
                        }
                    });
                    dialog.show();
                }
            }

            @Override
            public void onFailure(Call<VoucherResponse> call, Throwable t) {

            }
        });
    }
}