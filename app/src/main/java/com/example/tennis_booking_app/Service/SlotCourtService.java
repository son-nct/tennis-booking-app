package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.SlotCourt.SlotCourtRespone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface SlotCourtService {

    @GET("SlotCourt/PagedList")
    Call<SlotCourtRespone> getSlotCourt(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);
}
