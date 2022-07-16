package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CourtService {
    String COURT = "Court";

    @GET("Court/GetPromotingCourtHome")
    Call<List<PagedCourtResponse>> getPagedCourt(@Query("pageSize") String vendorID);

//    @GET("COURT")
//    Call<List<PagedCourtResponse>> getPagedPromoCourt(@Query("VendorId") int VendorId);

    @GET(COURT + "/GetPagedListPromotingCourt")
    Call<PagedCourtResponse> getPagedPromoCourt(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);

    @GET(COURT + "/GetPagedListHighRatingCourt")
    Call<PagedCourtResponse> getPagedListHighRating(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);
}
