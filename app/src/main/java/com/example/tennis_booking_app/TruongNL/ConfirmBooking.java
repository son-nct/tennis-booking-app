package com.example.tennis_booking_app.TruongNL;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.ThinhLTD.sancokm.SanKM;
import com.example.tennis_booking_app.TruongNL.datsan.CaChoi;

public class ConfirmBooking extends AppCompatActivity {
    TextView txtTennis2,txtTennis21,txtDientich2,txtNote,
            txtSlot,txtGia,txtNgay,txtGia2,txtTong;
    TextView edtPromo;
    Button btNhan;
    Intent intent1, intentKM;
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
        edtPromo=(TextView) findViewById(R.id.edtPromo);
        btNhan=(Button)findViewById(R.id.btNhan);
        txtNote=(TextView)findViewById(R.id.txtNote);

        intent1=getIntent();
        intentKM=getIntent();

        SanTennis ten2=(SanTennis) intent1.getSerializableExtra("sandetail2");
        SanKM tenKM=(SanKM) intentKM.getSerializableExtra("sandetailKM");

        if(ten2!=null){
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
        }

        if(tenKM!=null){
            CaChoi caChoiKM=(CaChoi)intentKM.getSerializableExtra("cadetail");
            String dateKM=intentKM.getStringExtra("date");
            String noteKM=intentKM.getStringExtra("note");
            txtTennis2.setText(tenKM.getTen());
            txtTennis21.setText(tenKM.getTen());
            txtDientich2.setText(tenKM.getDientich());
            txtSlot.setText(caChoiKM.getThoiluong());
            txtGia.setText(caChoiKM.getGia());
            txtGia2.setText(caChoiKM.getGia());
            txtTong.setText(Integer.parseInt(caChoiKM.getGia())- 10000);
            txtNgay.setText(dateKM);
            txtNote.setText(noteKM);
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
                intent1=new Intent(ConfirmBooking.this,ChucMung.class);
                startActivity(intent1);
            }
        });

    }
    private void DialogKM(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_khuyen_mai);
        dialog.setCanceledOnTouchOutside(false);

        dialog.show();
    }
}