package com.example.tennis_booking_app.Clients;

import com.example.tennis_booking_app.Service.BookingDetailService;
import com.example.tennis_booking_app.Service.SlotCourtService;
import com.example.tennis_booking_app.Service.UserService;
import com.example.tennis_booking_app.Service.CourtService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BEARER_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL2dyb3Vwc2lkIjoiIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiIzMiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJwaHVjaGxoMSIsImZhbWlseV9uYW1lIjoiSG9uZyBQaHVjIiwiaWF0IjoiNy8xMy8yMDIyIDM6MTQ6MDUgQU0iLCJqdGkiOiI3YzdjYjIzOC0yM2FlLTRkNjgtODhmOS00MDA1ZGU5ZjAwOWMiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJub3JtYWxVc2VyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwOS8wOS9pZGVudGl0eS9jbGFpbXMvYWN0b3IiOiIzIiwiZXhwIjoxNjg5MTkyODQ1LCJpc3MiOiJodHRwczovL2h1dm55LnRlY2giLCJhdWQiOiJodHRwczovL2h1dm55LnRlY2gifQ.ajxshCp0KqBea7hWQ28mMhX_mYpuOhTMJuVL3WWFCDc";


    private static Retrofit getRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://coreapi.softek.com.vn/api/")
                .client(okHttpClient)
                .build();
    }



    public static UserService getUserService() {
        return getRetrofit().create(UserService.class);
    }

    public static CourtService getVendorService() {
        return getRetrofit().create(CourtService.class);
    }
    public static SlotCourtService getSlotCourtService() {
        return getRetrofit().create(SlotCourtService.class);
    }
    public static BookingDetailService getBookingDetailService(){
        return getRetrofit().create(BookingDetailService.class);
    }
}
