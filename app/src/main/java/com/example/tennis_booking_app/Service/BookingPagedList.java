package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.Models.booking.PagedListRespone;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BookingPagedList {


    @GET("Court/GetOne")
    Call<List<PagedListRespone>> getPagedList(@Query("Id") String id);
    @GET("Booking/PagedList")
    Call<PagedListRespone> getPagedListYard(@Query("queryString") String queryString);
}
