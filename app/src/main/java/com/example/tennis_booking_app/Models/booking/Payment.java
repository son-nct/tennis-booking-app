package com.example.tennis_booking_app.Models.booking;

import java.util.Date;

public class Payment {
    private int id,bookingId,paymentAmount,statusId,userId,insertedBy,updateBy;
    private Date insertedDate,updateDate;
    private String refId;
    private boolean active;
    public PaymentDetail paymentDetail;

    public Payment(int id, int bookingId, int paymentAmount, int statusId, int userId, int insertedBy, int updateBy, Date insertedDate, Date updateDate, String refId, boolean active, PaymentDetail paymentDetail) {
        this.id = id;
        this.bookingId = bookingId;
        this.paymentAmount = paymentAmount;
        this.statusId = statusId;
        this.userId = userId;
        this.insertedBy = insertedBy;
        this.updateBy = updateBy;
        this.insertedDate = insertedDate;
        this.updateDate = updateDate;
        this.refId = refId;
        this.active = active;
        this.paymentDetail = paymentDetail;
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

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Date getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        this.insertedDate = insertedDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }
}
