package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.Slot.SlotRespone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface SlotService {

    @GET("Slot/GetSlotByDate")
    Call<List<SlotRespone>> getSlotbyDate(@Header("Authorization") String access_token, @Query("VendorId") int vendorId, @Query("CourtId") int courtId, @Query("BookedPlayDate") String bookedPlayDate, @Query("CourtTypeId") int courtTypeId);


    @GET("Slot/PagedList")
    Call<SlotRespone> getSlot(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);
}
