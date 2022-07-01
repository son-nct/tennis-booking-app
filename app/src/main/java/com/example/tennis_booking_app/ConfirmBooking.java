package com.example.tennis_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmBooking extends AppCompatActivity {
    TextView txtTennis2,txtTennis21,txtDientich2,txtNote,
            txtSlot,txtGia,txtNgay,txtGia2,txtTong;
    EditText edtPromo;
    Button btNhan;
    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        txtTennis2=(TextView)findViewById(R.id.txtTennis2);
        txtTennis21=(TextView)findViewById(R.id.txtTennis21);
        txtDientich2=(TextView)findViewById(R.id.txtDientich2);
        txtSlot=(TextView)findViewById(R.id.txtSlot);
        txtGia=(TextView)findViewById(R.id.txtGia);
        txtGia2=(TextView)findViewById(R.id.txtGia2);
        txtTong=(TextView)findViewById(R.id.txtTong);
        txtNgay=(TextView)findViewById(R.id.txtNgay);
        edtPromo=(EditText) findViewById(R.id.edtPromo);
        btNhan=(Button)findViewById(R.id.btNhan);
        txtNote=(TextView)findViewById(R.id.txtNote);

        intent1=getIntent();
        SanTennis ten2=(SanTennis) intent1.getSerializableExtra("sandetail2");
        CaChoi caChoi2=(CaChoi)intent1.getSerializableExtra("cadetail");
        String d=intent1.getStringExtra("date");
        String n=intent1.getStringExtra("note");

        txtTennis2.setText(ten2.getTen());
        txtTennis21.setText(ten2.getTen());
        txtDientich2.setText(ten2.getDientich());
        txtSlot.setText(caChoi2.getThoiluong());
        txtGia.setText(caChoi2.getGia());
        txtGia2.setText(caChoi2.getGia());
        txtTong.setText(caChoi2.getGia());
        txtNgay.setText(d);
        txtNote.setText(n);

//        edtPromo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent1=new Intent(ConfirmBooking.this,KhuyenMai.class);
//                startActivity(intent1);
//            }
//        });

        /*Promo promo=(Promo)intent1.getSerializableExtra("khuyenmai");
        edtPromo.setText(promo.getCuthe());*/

        btNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1=new Intent(ConfirmBooking.this,ChucMung.class);
                startActivity(intent1);
            }
        });

    }
}