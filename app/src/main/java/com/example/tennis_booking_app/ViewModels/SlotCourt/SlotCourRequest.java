package com.example.tennis_booking_app.ViewModels.SlotCourt;

public class SlotCourRequest{
        private int VendorID;
        private int PageSize;
        private String QueryString;
        private int CurrentPage;


    public SlotCourRequest() {
    }

    public SlotCourRequest(int vendorID, int pageSize, String queryString, int currentPage) {
        VendorID = vendorID;
        PageSize = pageSize;
        QueryString = queryString;
        CurrentPage = currentPage;
    }

    public int getVendorID() {
        return VendorID;
    }

    public void setVendorID(int vendorID) {
        VendorID = vendorID;
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
