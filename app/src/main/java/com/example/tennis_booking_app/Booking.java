package com.example.tennis_booking_app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.ViewModels.SlotCourt.SlotCourRequest;
import com.example.tennis_booking_app.ViewModels.SlotCourt.SlotCourtRespone;
import com.google.gson.Gson;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Booking extends AppCompatActivity {
    EditText edtTime;
    TextView txtTennis;
    ListView lvCaChoi;
    CaChoiAdapter adapter;
    ArrayList<CaChoi> arrCachoi;
    Intent intent, intentKM;
    ArrayList<CaChoi> arrSlotSelected;
    Button btOK;
    CheckBox cbCachoi;
    Token TOKEN;
    String AUTHORIZATION;
    List<SlotCourtRespone> arrSlotCourtRespone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        txtTennis = (TextView) findViewById(R.id.txtTennis);
        edtTime = (EditText) findViewById(R.id.edtTime);
        lvCaChoi = (ListView) findViewById(R.id.lvCaChoi);
        btOK = (Button) findViewById(R.id.btOK);
        cbCachoi = (CheckBox) findViewById(R.id.cbCaChoi);

        intent = getIntent();
        intentKM = getIntent();

        arrSlotSelected = new ArrayList<CaChoi>();

        SharedPreferences sh = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sh.getString("TOKEN","");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();

        SanTennis ten = (SanTennis) intent.getSerializableExtra("sandetail");
        SanKM sanKM = (SanKM) intentKM.getSerializableExtra("sanKMDetail");
        //CaChoi caChoi = (CaChoi) intent.getSerializableExtra("cachoi");

        if (ten == null) {
            txtTennis.setText(sanKM.getTen());
        } else {
            txtTennis.setText(ten.getTen());
        }


        edtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });

        anhxa();

        lvCaChoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CaChoi ca = arrCachoi.get(position);
                CheckBox cb_slot = (CheckBox) view.findViewById(R.id.cbCaChoi);

                if (cb_slot.isChecked()) {
                    cb_slot.setChecked(false);

                    if (arrSlotSelected.size() > 0) {
                        for (CaChoi caChoi : arrSlotSelected) {
                            if (caChoi.getId() == ca.getId()) {
                                arrSlotSelected.remove(caChoi);
                            }
                        }
                    }
                } else {
                    cb_slot.setChecked(true);
                    addSelectedSlot(ca);

                }

            }
        });


        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Booking.this, ConfirmBooking.class);
                if (ten != null) {
                    intent.putExtra("sandetail2", (Serializable) ten);
                }
                if (sanKM != null) {
                    intent.putExtra("sandetailKM", (Serializable) sanKM);
                }

                if (arrSlotSelected.size() == 0) {
                    Toast.makeText(Booking.this, "Xin vui lòng chọn ca chơi !", Toast.LENGTH_LONG).show();
                } else {
                    if (edtTime.length() == 0) {
                        Toast.makeText(Booking.this, "Xin vui lòng chọn ngày đặt !", Toast.LENGTH_LONG).show();
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("arrSlotSelected", (Serializable) arrSlotSelected);
                        bundle.putString("date", edtTime.getText().toString());

                        intent.putExtra("data", bundle);
                        startActivity(intent);
                    }
                }

            }
        });
    }

    private void addSelectedSlot(CaChoi ca) {
        arrSlotSelected.add(ca);
        System.out.println("size: " + arrSlotSelected.size());
        for (CaChoi cachoi : arrSlotSelected
        ) {
            System.out.println(cachoi.toString());
        }
    }

    private void chonngay() {
        Calendar calendar = Calendar.getInstance();
        int dd = calendar.get(Calendar.DATE);
        int MM = calendar.get(Calendar.MONTH);
        int yyyy = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(year, month, day);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtTime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, yyyy, MM, dd);
        datePickerDialog.show();
    }

    private void anhxa() {
        /*arrCachoi = new ArrayList<>();
        arrCachoi.add(new CaChoi(1, "Slot 1", "7:00-8:30", "150000", "150000 vnđ"));
        arrCachoi.add(new CaChoi(2, "Slot 2", "8:45-10:15", "150000", "150000 vnđ"));
        arrCachoi.add(new CaChoi(3, "Slot 3", "10:30-12:00", "150000", "150000 vnđ"));
        arrCachoi.add(new CaChoi(4, "Slot 4", "12:30-14:00", "170000", "170000 vnđ"));
        arrCachoi.add(new CaChoi(5, "Slot 5", "14:00-15:45", "170000", "170000 vnđ"));
        arrCachoi.add(new CaChoi(6, "Slot 6", "16:00-17:30", "170000", "170000 vnđ"));
        arrCachoi.add(new CaChoi(7, "Slot 7", "17:45-19:15", "200000", "200000 vnđ"));
        arrCachoi.add(new CaChoi(8, "Slot 8", "19:30-21:00", "200000", "200000 vnđ"));*/
        LoadSlotCourt();

        adapter = new CaChoiAdapter(this, R.layout.list_ca_choi, arrCachoi);
        lvCaChoi.setAdapter(adapter);
    }
    private void LoadSlotCourt(){
        SlotCourRequest slotCourRequest =new SlotCourRequest();
        slotCourRequest.setPageSize(5);
        slotCourRequest.setVendorID(11);
        slotCourRequest.setQueryString("");
        slotCourRequest.setCurrentPage(1);

        Call<SlotCourtRespone> SlotCourtResponeCall=ApiClient.getSlotCourtService().getSlotCourt(AUTHORIZATION,slotCourRequest.getVendorID(), slotCourRequest.getPageSize(), slotCourRequest.getQueryString(), slotCourRequest.getCurrentPage());
        System.out.println("request url \n" + SlotCourtResponeCall.request().url());

        SlotCourtResponeCall.enqueue(new Callback<SlotCourtRespone>() {
            @Override
            public void onResponse(Call<SlotCourtRespone> call, Response<SlotCourtRespone> response) {
                if(response.body() != null) {
                    System.out.println("body: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<SlotCourtRespone> call, Throwable t) {

            }
        });
    }
}