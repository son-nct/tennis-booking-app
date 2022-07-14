package com.example.tennis_booking_app.Models.booking;

import java.util.Date;

public class Value {
    private int id, vendorId, totalPrice, updatedBy, statusId, paymentId;
    private Date insertedDate, updatedDate;
    private String note;
    private boolean active;
    public BookingDetail bookingDetail;
    public Payment payment;


    public Value(int id, int vendorId, int totalPrice, int updatedBy, int statusId, int paymentId, Date insertedDate, Date updatedDate, String note, boolean active, BookingDetail bookingDetail, Payment payment) {
        this.id = id;
        this.vendorId = vendorId;
        this.totalPrice = totalPrice;
        this.updatedBy = updatedBy;
        this.statusId = statusId;
        this.paymentId = paymentId;
        this.insertedDate = insertedDate;
        this.updatedDate = updatedDate;
        this.note = note;
        this.active = active;
        this.bookingDetail = bookingDetail;
        this.payment = payment;
    }


    public int getId() {
        return id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public int getStatusId() {
        return statusId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Date getInsertedDate() {
        return insertedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public String getNote() {
        return note;
    }

    public boolean isActive() {
        return active;
    }

    public BookingDetail getBookingDetail() {
        return bookingDetail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setInsertedDate(Date insertedDate) {
        this.insertedDate = insertedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setBookingDetail(BookingDetail bookingDetail) {
        this.bookingDetail = bookingDetail;
    }
}
