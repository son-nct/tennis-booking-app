package com.example.tennis_booking_app.ViewModels.Slot;

import com.example.tennis_booking_app.Models.Slot.SlotValue;

import java.util.List;

public class SlotRespone {
    private int Count,FirstItemOnPage,PageNumber,PageCount,PageSize,LastItemOnPage;
    private boolean HasNextPage,HasPreviousPage,IsFirstPage,IsLastPage;
    List<SlotValue> Value;

    public SlotRespone(int count, int firstItemOnPage, int pageNumber, int pageCount, int pageSize, int lastItemOnPage, boolean hasNextPage, boolean hasPreviousPage, boolean isFirstPage, boolean isLastPage, List<SlotValue> value) {
        Count = count;
        FirstItemOnPage = firstItemOnPage;
        PageNumber = pageNumber;
        PageCount = pageCount;
        PageSize = pageSize;
        LastItemOnPage = lastItemOnPage;
        HasNextPage = hasNextPage;
        HasPreviousPage = hasPreviousPage;
        IsFirstPage = isFirstPage;
        IsLastPage = isLastPage;
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

    public List<SlotValue> getValue() {
        return Value;
    }

    public void setValue(List<SlotValue> value) {
        Value = value;
    }
}
