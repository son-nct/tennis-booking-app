package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.Models.BookingDetail.BookingDetailRespone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface BookingDetailService {
    @GET("BookingDetail/GetOne")
    Call<BookingDetailRespone> getBookingDetail(@Header("Authorization") String access_token, @Query("VendorId") int Id);

}
