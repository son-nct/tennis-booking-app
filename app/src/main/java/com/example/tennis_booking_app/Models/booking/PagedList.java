package com.example.tennis_booking_app.Models.booking;

public class PagedList {
    private int count,firstItemOnPage,pageNumber,pageCount,pageSize,lastItemOnPage;
    private boolean hasNextPage,hasPreviousPage,isFirstPage,isLastPage;
    public Value value;

    public PagedList() {
    }

    public PagedList(int count, int firstItemOnPage, int pageNumber, int pageCount, int pageSize, int lastItemOnPage, boolean hasNextPage, boolean hasPreviousPage, boolean isFirstPage, boolean isLastPage, Value value) {
        this.count = count;
        this.firstItemOnPage = firstItemOnPage;
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.lastItemOnPage = lastItemOnPage;
        this.hasNextPage = hasNextPage;
        this.hasPreviousPage = hasPreviousPage;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public int getFirstItemOnPage() {
        return firstItemOnPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getLastItemOnPage() {
        return lastItemOnPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public Value getValue() {
        return value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFirstItemOnPage(int firstItemOnPage) {
        this.firstItemOnPage = firstItemOnPage;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setLastItemOnPage(int lastItemOnPage) {
        this.lastItemOnPage = lastItemOnPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
