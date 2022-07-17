package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.example.tennis_booking_app.ViewModels.PagedCourtByType.PagedCourtTypeRespone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CourtService {

    @GET("Court/GetPagedListCourtByType")
    Call<PagedCourtTypeRespone> getPagedType(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage,@Query("typeId") int TypeId);

    @GET("Court/GetPagedListPromotingCourt")
    Call<PagedCourtResponse> getPagedPromoCourt(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);
}
