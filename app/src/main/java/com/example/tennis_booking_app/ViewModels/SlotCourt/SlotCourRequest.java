package com.example.tennis_booking_app.ViewModels.SlotCourt;

public class SlotCourRequest{
        private int VendorId;
        private int PageSize;
        private String queryString;
        private int CurrentPage;


    public SlotCourRequest() {
    }

    public SlotCourRequest(int vendorId, int pageSize, String queryString, int currentPage) {
        VendorId = vendorId;
        PageSize = pageSize;
        this.queryString = queryString;
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
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }
}
