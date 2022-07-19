package com.example.tennis_booking_app.ViewModels.Booking;

public class BookingRequest {
    private int VendorId;
    private int PageSize;
    private String QueryString;
    private int CurrentPage;

    public BookingRequest() {
    }

    public BookingRequest(int vendorId, int pageSize, String queryString, int currentPage) {
        VendorId = vendorId;
        PageSize = pageSize;
        QueryString = queryString;
        CurrentPage = currentPage;
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getQueryString() {
        return QueryString;
    }

    public void setQueryString(String queryString) {
        QueryString = queryString;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

}
