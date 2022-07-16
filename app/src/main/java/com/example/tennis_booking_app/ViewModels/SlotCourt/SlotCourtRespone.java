package com.example.tennis_booking_app.ViewModels.SlotCourt;

import com.example.tennis_booking_app.Models.SlotCourtValue;

import java.util.List;

public class SlotCourtRespone {
    private int Count;
    private int FirstItemOnPage;
    private boolean HasNextPage;
    private boolean HasPreviousPage;
    private boolean IsFirstPage;
    private boolean IsLastPage;
    private int PageNumber;
    private int PageCount;
    private int PageSize;
    private int LastItemOnPage;

    List<SlotCourtValue> Value;

    public SlotCourtRespone(int count, int firstItemOnPage, boolean hasNextPage, boolean hasPreviousPage, boolean isFirstPage, boolean isLastPage, int pageNumber, int pageCount, int pageSize, int lastItemOnPage, List<SlotCourtValue> value) {
        Count = count;
        FirstItemOnPage = firstItemOnPage;
        HasNextPage = hasNextPage;
        HasPreviousPage = hasPreviousPage;
        IsFirstPage = isFirstPage;
        IsLastPage = isLastPage;
        PageNumber = pageNumber;
        PageCount = pageCount;
        PageSize = pageSize;
        LastItemOnPage = lastItemOnPage;
        Value = value;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getFirstItemOnPage() {
        return FirstItemOnPage;
    }

    public void setFirstItemOnPage(int firstItemOnPage) {
        FirstItemOnPage = firstItemOnPage;
    }

    public boolean isHasNextPage() {
        return HasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        HasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return HasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        HasPreviousPage = hasPreviousPage;
    }

    public boolean isFirstPage() {
        return IsFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        IsFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return IsLastPage;
    }

    public void setLastPage(boolean lastPage) {
        IsLastPage = lastPage;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getLastItemOnPage() {
        return LastItemOnPage;
    }

    public void setLastItemOnPage(int lastItemOnPage) {
        LastItemOnPage = lastItemOnPage;
    }

    public List<SlotCourtValue> getValue() {
        return Value;
    }

    public void setValue(List<SlotCourtValue> value) {
        Value = value;
    }
}
