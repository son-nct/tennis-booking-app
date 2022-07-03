package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.LoginRequest;
import com.example.tennis_booking_app.ViewModels.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {


    @POST("User/SignIn")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);


}