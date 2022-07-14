package com.example.tennis_booking_app.Models.booking;

import java.util.Date;

public class BookingDetail {
    private int id,bookingId,courtId,slotId,totalPrice,
    totalPriceAfterDiscount,voucherId,statusId,insertedBy,updateBy,ratedStar;
    private Date bookedPlayDate,insertedDate,updatedDate;
    private String note;
    private boolean active;
    public Payment payment;

    public BookingDetail(int id, int bookingId, int courtId, int slotId, int totalPrice, int totalPriceAfterDiscount, int voucherId, int statusId, int insertedBy, int updateBy, int ratedStar, Date bookedPlayDate, Date insertedDate, Date updatedDate, String note, boolean active,Payment payment) {
        this.id = id;
        this.bookingId = bookingId;
        this.courtId = courtId;
        this.slotId = slotId;
        this.totalPrice = totalPrice;
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
        this.voucherId = voucherId;
        this.statusId = statusId;
        this.insertedBy = insertedBy;
        this.updateBy = updateBy;
        this.ratedStar = ratedStar;
        this.bookedPlayDate = bookedPlayDate;
        this.insertedDate = insertedDate;
        this.updatedDate = updatedDate;
        this.note = note;
        this.active = active;
        this.payment=payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }

    public void setTotalPriceAfterDiscount(int totalPriceAfterDiscount) {
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        this.insertedBy = insertedBy;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public int getRatedStar() {
        return ratedStar;
    }

    public void setRatedStar(int ratedStar) {
        this.ratedStar = ratedStar;
    }

    public Date getBookedPlayDate() {
        return bookedPlayDate;
    }

    public void setBookedPlayDate(Date bookedPlayDate) {
        this.bookedPlayDate = bookedPlayDate;
    }

    public Date getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        this.insertedDate = insertedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
