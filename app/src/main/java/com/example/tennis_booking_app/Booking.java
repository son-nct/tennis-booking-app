package com.example.tennis_booking_app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
        lvCaChoi.setClickable(false);

        lvCaChoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CaChoi ca = arrCachoi.get(position);
                if(cbCachoi.isChecked()){
                    cbCachoi.setChecked(false);
                }else{
                    cbCachoi.setChecked(true);
                }
                if (!cbCachoi.isChecked()) {
                    if (arrSlotSelected.size() > 0) {
                        for (CaChoi caChoi : arrSlotSelected) {
                            if (caChoi.getId() == ca.getId()) {
                                arrSlotSelected.remove(caChoi);
                            }
                        }
                    }
                } else {
                    arrSlotSelected.add(ca);

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
                Bundle bundle = new Bundle();
                bundle.putSerializable("arrSlotSelected", (Serializable) arrSlotSelected);
                bundle.putString("date", edtTime.getText().toString());

                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
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
        arrCachoi = new ArrayList<>();
        arrCachoi.add(new CaChoi(1, "Slot 1", "7:00-8:30", "150,000"));
        arrCachoi.add(new CaChoi(2, "Slot 2", "8:45-10:15", "150,000"));
        arrCachoi.add(new CaChoi(3, "Slot 3", "10:30-12:00", "150,000"));
        arrCachoi.add(new CaChoi(4, "Slot 4", "12:30-14:00", "150,000"));
        arrCachoi.add(new CaChoi(5, "Slot 5", "14:00-15:45", "150,000"));
        arrCachoi.add(new CaChoi(6, "Slot 6", "16:00-17:30", "150,000"));
        arrCachoi.add(new CaChoi(7, "Slot 7", "17:45-19:15", "150,000"));
        arrCachoi.add(new CaChoi(8, "Slot 8", "19:30-21:00", "150,000"));

        adapter = new CaChoiAdapter(this, R.layout.list_ca_choi, arrCachoi);
        lvCaChoi.setAdapter(adapter);
    }

}