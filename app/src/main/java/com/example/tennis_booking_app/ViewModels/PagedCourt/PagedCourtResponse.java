package com.example.tennis_booking_app.ViewModels.PagedCourt;

import com.example.tennis_booking_app.Models.PagedCourtValue;

public class PagedCourtResponse {
    private int count;
    private int firstItemOnPage;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int pageNumber;
    private int pageCount;
    private int pageSize;
    private int lastItemOnPage;

    PagedCourtValue value;

    public PagedCourtResponse(int count, int firstItemOnPage, boolean hasNextPage, boolean hasPreviousPage, boolean isFirstPage, boolean isLastPage, int pageNumber, int pageCount, int pageSize, int lastItemOnPage, PagedCourtValue value) {
        this.count = count;
        this.firstItemOnPage = firstItemOnPage;
        this.hasNextPage = hasNextPage;
        this.hasPreviousPage = hasPreviousPage;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.lastItemOnPage = lastItemOnPage;
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFirstItemOnPage() {
        return firstItemOnPage;
    }

    public void setFirstItemOnPage(int firstItemOnPage) {
        this.firstItemOnPage = firstItemOnPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getLastItemOnPage() {
        return lastItemOnPage;
    }

    public void setLastItemOnPage(int lastItemOnPage) {
        this.lastItemOnPage = lastItemOnPage;
    }

    public PagedCourtValue getValue() {
        return value;
    }

    public void setValue(PagedCourtValue value) {
        this.value = value;
    }
}
