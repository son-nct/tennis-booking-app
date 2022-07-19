package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.Booking.BookingRespone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface BookingService {
    @GET("Booking/PagedList")
    Call<BookingRespone> getBooking(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);
}
