package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CourtService {
    String COURT = "Court";
    String TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL2dyb3Vwc2lkIjoiIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiIzMiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJwaHVjaGxoMSIsImZhbWlseV9uYW1lIjoiSG9uZyBQaHVjIiwiaWF0IjoiNy8xMy8yMDIyIDM6MTQ6MDUgQU0iLCJqdGkiOiI3YzdjYjIzOC0yM2FlLTRkNjgtODhmOS00MDA1ZGU5ZjAwOWMiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJub3JtYWxVc2VyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwOS8wOS9pZGVudGl0eS9jbGFpbXMvYWN0b3IiOiIzIiwiZXhwIjoxNjg5MTkyODQ1LCJpc3MiOiJodHRwczovL2h1dm55LnRlY2giLCJhdWQiOiJodHRwczovL2h1dm55LnRlY2gifQ.ajxshCp0KqBea7hWQ28mMhX_mYpuOhTMJuVL3WWFCDc";

    @GET("Court/GetPromotingCourtHome")
    Call<List<PagedCourtResponse>> getPagedCourt(@Query("pageSize") String vendorID);

//    @GET("COURT")
//    Call<List<PagedCourtResponse>> getPagedPromoCourt(@Query("VendorId") int VendorId);
    
    @Headers("Authorization" + TOKEN)
    @GET(COURT + "/GetPagedListPromotingCourt")
    Call<List<PagedCourtResponse>> getPagedPromoCourt(@Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);
}
