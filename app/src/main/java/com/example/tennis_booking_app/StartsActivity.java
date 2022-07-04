package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.Login.LoginRequest;
import com.example.tennis_booking_app.Models.Login.LoginResponse;
import com.example.tennis_booking_app.activity.home.HomeActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartsActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnContinue;
    private CheckBox cbMessage;
    private TextView tvforgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starts);

        etUsername = (EditText) findViewById(R.id.txtUsername);
        etPassword = (EditText) findViewById(R.id.txtPassword);
        btnContinue = (Button) findViewById(R.id.btnContinue);
        cbMessage = (CheckBox) findViewById(R.id.cbMessage);
        tvforgotPassword = (TextView) findViewById(R.id.tvforgotPassword);

        tvforgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartsActivity.this, Retrieval.class);
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
                if (TextUtils.isEmpty(etUsername.getText().toString()) || TextUtils.isEmpty(etPassword.getText().toString())) {
                    Toast.makeText(StartsActivity.this, "Username / Password Required", Toast.LENGTH_LONG).show();
                } else {
                    login();
                }
            }
        });

    }

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(etUsername.getText().toString());
        loginRequest.setPassword(etPassword.getText().toString());
        loginRequest.setClientId(3);
        loginRequest.setAutoSignIn(true);

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(StartsActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(StartsActivity.this, HomeActivity.class).putExtra("data", loginResponse.getToken().getUserName()));
                        }
                    }, 700);

                } else {
                    Toast.makeText(StartsActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(StartsActivity.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}