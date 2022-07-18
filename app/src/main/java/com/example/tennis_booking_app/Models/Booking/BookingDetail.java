package com.example.tennis_booking_app.Models.Booking;

import java.util.Date;

public class BookingDetail {
    private int Id,BookingId,CourtId,SlotId,TotalPrice,TotalPriceAfterDiscount,
            VoucherId,StatusId,InsertedBy,UpdateBy,RatedStar;
    private Date BookedPlayDate,InsertedDate,UpdatedDate;
    private boolean Active;
    private String Note;

    public BookingDetail() {
    }

    public BookingDetail(int id, int bookingId, int courtId, int slotId, int totalPrice, int totalPriceAfterDiscount, int voucherId, int statusId, int insertedBy, int updateBy, int ratedStar, Date bookedPlayDate, Date insertedDate, Date updatedDate, boolean active, String note) {
        Id = id;
        BookingId = bookingId;
        CourtId = courtId;
        SlotId = slotId;
        TotalPrice = totalPrice;
        TotalPriceAfterDiscount = totalPriceAfterDiscount;
        VoucherId = voucherId;
        StatusId = statusId;
        InsertedBy = insertedBy;
        UpdateBy = updateBy;
        RatedStar = ratedStar;
        BookedPlayDate = bookedPlayDate;
        InsertedDate = insertedDate;
        UpdatedDate = updatedDate;
        Active = active;
        Note = note;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public int getCourtId() {
        return CourtId;
    }

    public void setCourtId(int courtId) {
        CourtId = courtId;
    }

    public int getSlotId() {
        return SlotId;
    }

    public void setSlotId(int slotId) {
        SlotId = slotId;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public int getTotalPriceAfterDiscount() {
        return TotalPriceAfterDiscount;
    }

    public void setTotalPriceAfterDiscount(int totalPriceAfterDiscount) {
        TotalPriceAfterDiscount = totalPriceAfterDiscount;
    }

    public int getVoucherId() {
        return VoucherId;
    }

    public void setVoucherId(int voucherId) {
        VoucherId = voucherId;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
    }

    public int getInsertedBy() {
        return InsertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        InsertedBy = insertedBy;
    }

    public int getUpdateBy() {
        return UpdateBy;
    }

    public void setUpdateBy(int updateBy) {
        UpdateBy = updateBy;
    }

    public int getRatedStar() {
        return RatedStar;
    }

    public void setRatedStar(int ratedStar) {
        RatedStar = ratedStar;
    }

    public Date getBookedPlayDate() {
        return BookedPlayDate;
    }

    public void setBookedPlayDate(Date bookedPlayDate) {
        BookedPlayDate = bookedPlayDate;
    }

    public Date getInsertedDate() {
        return InsertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        InsertedDate = insertedDate;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        UpdatedDate = updatedDate;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
