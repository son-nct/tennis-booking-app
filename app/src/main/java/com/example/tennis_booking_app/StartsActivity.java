package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class StartsActivity extends AppCompatActivity {
     private EditText tvNhap;
     private EditText tvnhap;
     private Button   btnContinue;
     private CheckBox cbMessage;
     private TextView tvforgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starts);
        tvNhap = (EditText) findViewById(R.id.tvNhap);
        tvnhap= (EditText) findViewById(R.id.tvnhap);
        btnContinue = (Button) findViewById(R.id.btnContinue);
        cbMessage = (CheckBox) findViewById(R.id.cbMessage);
        tvforgotPassword = (TextView) findViewById(R.id.tvforgotPassword);

        tvforgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartsActivity.this,Retrieval.class);
                startActivity(intent);
            }
        });
        //clicktieptuc

        cbMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = tvNhap.getText().toString();
                String pass= tvnhap.getText().toString();
                //nếu tài khoản mật khẩu đúng thì qua SignupSucess
                if(userName.equals("thinhltd@gmail.com") && pass.equals("a")){
                    Intent intent = new Intent(StartsActivity.this,SignUpSuccess.class);
                    startActivity(intent);
                }
            }
        });
    }
}