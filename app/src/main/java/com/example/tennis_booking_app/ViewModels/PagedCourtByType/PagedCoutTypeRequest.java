package com.example.tennis_booking_app.ViewModels.PagedCourtByType;

public class PagedCoutTypeRequest {
    private int vendorID;
    private int pageSize;
    private String queryString;
    private int currentPage;
    private int typeId;


    public PagedCoutTypeRequest() {
    }

    public PagedCoutTypeRequest(int vendorID, int pageSize, String queryString, int currentPage, int typeId) {
        this.vendorID = vendorID;
        this.pageSize = pageSize;
        this.queryString = queryString;
        this.currentPage = currentPage;
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
