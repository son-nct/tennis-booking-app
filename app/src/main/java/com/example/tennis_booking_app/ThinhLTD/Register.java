package com.example.tennis_booking_app.ThinhLTD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.ViewModels.Register.RegisterRequest;
import com.example.tennis_booking_app.ViewModels.Register.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText txtUsername, txtEmail, txtPassword, txtConfirm, txtFullname, txtPhone;
    CheckBox chkCheck;
    Button btnRegister;
    String username, email, password, confirmPass, fullname, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        changeStatusBarColor();

//        txtUsername = findViewById(R.id.textInputName);
//        txtEmail = findViewById(R.id.textInputEmail);
//        txtPassword = findViewById(R.id.textInputPassword);
////        txtConfirm = findViewById(R.id.txtConfirm);
////        txtFullname = findViewById(R.id.txtFullname);
////        txtPhone = findViewById(R.id.txtPhone);
////        chkCheck = findViewById(R.id.chkCheck);
//        btnRegister = findViewById(R.id.btnRegister);

//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (checkCondition()) {
//                    register();
//                } else {
//                    Toast.makeText(Register.this, "Input your empty field and try again", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

//    private void getData() {
//        username = txtUsername.getText().toString();
//        email = txtEmail.getText().toString();
//        password = txtPassword.getText().toString();
//        confirmPass = txtConfirm.getText().toString();
//        fullname = txtFullname.getText().toString();
//        phone = txtPhone.getText().toString();
//    }

//    private void register() {
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername(username);
//        registerRequest.setEmail(email);
//        registerRequest.setPassword(password);
//        registerRequest.setConfirmPassword(confirmPass);
//        registerRequest.setFullName(fullname);
//        registerRequest.setPhoneNumber(phone);
//        registerRequest.setClientID(3);
//
//        Call<RegisterResponse> registerResponseCall = ApiClient.getUserService().userRegister(registerRequest);
//        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
//            @Override
//            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(Register.this, response.message(), Toast.LENGTH_SHORT).show();
//                    RegisterResponse registerResponse = response.body();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            Intent intent = new Intent(Register.this, StartsActivity.class);
//                            startActivity(intent);
//                        }
//                    }, 700);
//                } else {
//                    Toast.makeText(Register.this, "Failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                Toast.makeText(Register.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//
//    private boolean checkCondition() {
//        getData();
//        if (username.length() == 0) {
//            setError(txtUsername, "Username không được để trống");
//            return false;
//        } else if (email.length() == 0) {
//            setError(txtEmail, "Email không được để trống");
//            return false;
//        } else if (password.length() == 0) {
//            setError(txtPassword, "Mật khẩu không được để trống");
//            return false;
//        } else if (confirmPass.length() == 0 && !password.equals(confirmPass)) {
//            setError(txtConfirm, "Nhập lại mật khẩu không chính xác");
//            return false;
//        } else if (fullname.length() == 0) {
//            setError(txtConfirm, "Tên đầy đủ không được để trống");
//            return false;
//        } else if (phone.length() == 0) {
//            setError(txtConfirm, "Số điện thoại không được để trống");
//            return false;
//        } else return true;
//    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(this, StartsActivity.class));
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

    private void setError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}