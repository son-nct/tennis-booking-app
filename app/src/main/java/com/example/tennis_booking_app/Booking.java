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
import android.widget.Toast;

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

        arrSlotSelected = new ArrayList<CaChoi>();

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

                Toast.makeText(Booking.this, "đã chọn", Toast.LENGTH_SHORT).show();
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
        arrCachoi = new ArrayList<>();
        arrCachoi.add(new CaChoi(1, "Slot 1", "7:00-8:30", "150000", "150000 vnđ"));
        arrCachoi.add(new CaChoi(2, "Slot 2", "8:45-10:15", "150000", "150000 vnđ"));
        arrCachoi.add(new CaChoi(3, "Slot 3", "10:30-12:00", "150000", "150000 vnđ"));
        arrCachoi.add(new CaChoi(4, "Slot 4", "12:30-14:00", "170000", "170000 vnđ"));
        arrCachoi.add(new CaChoi(5, "Slot 5", "14:00-15:45", "170000", "170000 vnđ"));
        arrCachoi.add(new CaChoi(6, "Slot 6", "16:00-17:30", "170000", "170000 vnđ"));
        arrCachoi.add(new CaChoi(7, "Slot 7", "17:45-19:15", "200000", "200000 vnđ"));
        arrCachoi.add(new CaChoi(8, "Slot 8", "19:30-21:00", "200000", "200000 vnđ"));

        adapter = new CaChoiAdapter(this, R.layout.list_ca_choi, arrCachoi);
        lvCaChoi.setAdapter(adapter);
    }

}