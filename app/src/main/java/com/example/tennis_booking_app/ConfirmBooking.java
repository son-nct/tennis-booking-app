package com.example.tennis_booking_app;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.Models.Voucher;
import com.example.tennis_booking_app.ViewModels.Slot.SlotRespone;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ConfirmBooking extends AppCompatActivity {
    TextView txtVendorID, txtCourtName, txtDientich2,
            txtSlot, txtGia, txtNgay, txtThanhGia, txtTongGia;
    TextView edtPromo;
    Button btNhan, btKM1, btKM2, btKM3;
    Intent intent1, intentKM, intentConfirm, intentValue, intentVoucher;
    ArrayList<SlotRespone> arrSelected;
    int sum = 0;
    PagedCourtValue courtValue;
    ArrayList<Voucher> arrVoucher;
    Token TOKEN;
    String AUTHORIZATION;
    SharedPreferences sharedPreferences;
    Bundle bundle, bundleVoucher;
    ArrayList<VoidcherTest> listVoicher;
    VoicherAdapter adapter;
    ListView lvVoucher;


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
        intentConfirm = getIntent();
        intentValue = getIntent();
        intentVoucher = getIntent();


//get sharedPreference
        sharedPreferences = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sharedPreferences.getString("TOKEN", "");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();

        //SanTennis ten2 = (SanTennis) intent1.getSerializableExtra("sandetail2");
//        SanKM tenKM = (SanKM) intentKM.getSerializableExtra("sandetailKM");

        bundle = intentConfirm.getBundleExtra("data");
        arrSelected = (ArrayList<SlotRespone>) bundle.getSerializable("arrSlotSelected");
        courtValue = (PagedCourtValue) bundle.getSerializable("courtValue");

//        bundleVoucher = intentVoucher.getBundleExtra("voucher");
//        arrVoucher = (ArrayList<Voucher>) bundleVoucher.getSerializable("voucherARR");





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
            //CaChoi caChoi2 = (CaChoi) intent1.getSerializableExtra("cadetail");
            String d = bundle.getString("date");
            txtVendorID.setText(courtValue.getName());
            txtCourtName.setText(courtValue.getName());
//            txtDientich2.setText(courtValue.getDientich());
            if (arrSelected.size() > 0) {
                String selected_slot = "";
                String selected_slot_price = "";

                for (SlotRespone caChoi : arrSelected) {
                    selected_slot += caChoi.getStartTime() + ", ";
                    selected_slot_price += caChoi.getPrice() + ", ";
                    sum += Integer.parseInt(caChoi.getPrice() + "");

                }

                txtSlot.setText(selected_slot);
                txtGia.setText(selected_slot_price);
                txtThanhGia.setText(sum + " vnđ");
                txtTongGia.setText(sum + " vnđ");
//                    txtTong.setText(sum);

//                System.out.println("slot : "+ selected_slot);
//                System.out.println("price_slot : "+ selected_slot_price);
//                System.out.println("price : "+ sum);
            }

            txtNgay.setText(d);
        }

        edtPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDialogKM();
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

    private void loadDialogKM() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_khuyen_mai);
        dialog.setCanceledOnTouchOutside(false);

        lvVoucher=dialog.findViewById(R.id.lvVoucher);
        listVoicher=new ArrayList<>();
        listVoicher.add(new VoidcherTest("cuoi tuan","20000"));
        adapter=new VoicherAdapter(dialog.getContext(),R.layout.list_voicher,listVoicher);
        lvVoucher.setAdapter(adapter);

        DialogVoucherAdapter voucherAdapter = new DialogVoucherAdapter(ConfirmBooking.this, arrVoucher, sharedPreferences);
        dialog.show();


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

    }
}