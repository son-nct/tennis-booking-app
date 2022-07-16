package com.example.tennis_booking_app.Models.BookingDetail;

import java.util.Date;

public class PaymentDetail {
    private int id,paymentId,courtId,paymentAmount,userId,statusId,insertedBy,updatedBy;
    private Date insertedDate,updatedDate;
    private boolean active;

    public PaymentDetail(int id, int paymentId, int courtId, int paymentAmount, int userId, int statusId, int insertedBy, int updatedBy, Date insertedDate, Date updatedDate, boolean active) {
        this.id = id;
        this.paymentId = paymentId;
        this.courtId = courtId;
        this.paymentAmount = paymentAmount;
        this.userId = userId;
        this.statusId = statusId;
        this.insertedBy = insertedBy;
        this.updatedBy = updatedBy;
        this.insertedDate = insertedDate;
        this.updatedDate = updatedDate;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
