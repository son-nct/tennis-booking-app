package com.example.tennis_booking_app.ViewModels.PagedCourt;

public class PagedCourtRequest {
    private int shopID;
    private int pageSize;
    private String q;
    private int page;
    private int tab;

    public PagedCourtRequest(int shopID, int pageSize, String q, int page, int tab) {
        this.shopID = shopID;
        this.pageSize = pageSize;
        this.q = q;
        this.page = page;
        this.tab = tab;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }
}
