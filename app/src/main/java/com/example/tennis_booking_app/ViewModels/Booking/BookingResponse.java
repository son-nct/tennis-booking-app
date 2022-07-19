package com.example.tennis_booking_app.ViewModels.Booking;

import com.example.tennis_booking_app.Models.Booking.BookingDetail;

import java.util.Date;
import java.util.List;

public class BookingResponse {
    private int VendorId;
    private int TotalPrice;
    private Date InsertedDate;
    private int InsertedBy;
    private Date UpdatedDate;
    private int UpdatedBy;
    private String Note;
    private boolean Active;

    List<BookingDetail> BookingDetail;

    public BookingResponse(int vendorId, int totalPrice, Date insertedDate, int insertedBy, Date updatedDate, int updatedBy, String note, boolean active, List<com.example.tennis_booking_app.Models.Booking.BookingDetail> bookingDetail) {
        VendorId = vendorId;
        TotalPrice = totalPrice;
        InsertedDate = insertedDate;
        InsertedBy = insertedBy;
        UpdatedDate = updatedDate;
        UpdatedBy = updatedBy;
        Note = note;
        Active = active;
        BookingDetail = bookingDetail;
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public Date getInsertedDate() {
        return InsertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        InsertedDate = insertedDate;
    }

    public int getInsertedBy() {
        return InsertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        InsertedBy = insertedBy;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        UpdatedDate = updatedDate;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public List<com.example.tennis_booking_app.Models.Booking.BookingDetail> getBookingDetail() {
        return BookingDetail;
    }

    public void setBookingDetail(List<com.example.tennis_booking_app.Models.Booking.BookingDetail> bookingDetail) {
        BookingDetail = bookingDetail;
    }
}
