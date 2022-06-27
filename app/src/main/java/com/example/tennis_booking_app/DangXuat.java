package com.example.tennis_booking_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DangXuat extends AppCompatActivity {
    Button btDangxuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_xuat);
        btDangxuat = (Button) findViewById(R.id.btDangxuat);
        btDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDX();
            }
        });
    }

    private void DialogDX(){
        AlertDialog.Builder dialogDX=new AlertDialog.Builder(this);
        dialogDX.setMessage("Ban co muon dang xuat?");

        dialogDX.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =new Intent(DangXuat.this,ReadyLogin.class);
                startActivity(intent);
            }
        });

        dialogDX.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogDX.show();
    }
}