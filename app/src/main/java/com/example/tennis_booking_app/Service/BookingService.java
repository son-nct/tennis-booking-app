package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.Booking.BookingResponse;
import com.example.tennis_booking_app.ViewModels.BookingHistory.BookingHistoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BookingService {
    @GET("Booking/PagedList")
    Call<BookingHistoryResponse> getBooking(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);

    @POST("Booking")
    Call<List<BookingResponse>> bookingOneCourt(@Header("Authortization") String access_token, @Body BookingResponse bookingResponse);
}
