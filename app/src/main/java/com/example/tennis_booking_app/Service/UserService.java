package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.Models.Login.LoginRequest;
import com.example.tennis_booking_app.Models.Login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {


    @POST("User/SignIn")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);


}