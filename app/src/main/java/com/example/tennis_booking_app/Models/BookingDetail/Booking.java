package com.example.tennis_booking_app.Models.BookingDetail;

import java.util.Date;
import java.util.List;

public class Booking {
    private int id,vendorId,totalPrice,insertedBy,updatedBy,statusId,paymentId;
    private Date insertedDate,updatedDate;
    private String note;
    private boolean active;
    List<BookingDetail> bookingDetail;
    List<Payment> paymen;

    public Booking(int id, int vendorId, int totalPrice, int insertedBy, int updatedBy, int statusId, int paymentId, Date insertedDate, Date updatedDate, String note, boolean active, List<BookingDetail> bookingDetail, List<Payment> paymen) {
        this.id = id;
        this.vendorId = vendorId;
        this.totalPrice = totalPrice;
        this.insertedBy = insertedBy;
        this.updatedBy = updatedBy;
        this.statusId = statusId;
        this.paymentId = paymentId;
        this.insertedDate = insertedDate;
        this.updatedDate = updatedDate;
        this.note = note;
        this.active = active;
        this.bookingDetail = bookingDetail;
        this.paymen = paymen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        this.insertedBy = insertedBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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

    public List<BookingDetail> getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(List<BookingDetail> bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public List<Payment> getPaymen() {
        return paymen;
    }

    public void setPaymen(List<Payment> paymen) {
        this.paymen = paymen;
    }
}
