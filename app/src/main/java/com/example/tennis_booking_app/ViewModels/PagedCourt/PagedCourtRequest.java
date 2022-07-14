package com.example.tennis_booking_app.ViewModels.PagedCourt;

public class PagedCourtRequest {
    private int vendorID;
    private int pageSize;
    private String queryString;
    private int currentPage;


    public PagedCourtRequest() {
    }

    public PagedCourtRequest(int vendorID, int pageSize, String queryString, int currentPage) {
        this.vendorID = vendorID;
        this.pageSize = pageSize;
        this.queryString = queryString;
        this.currentPage = currentPage;
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
