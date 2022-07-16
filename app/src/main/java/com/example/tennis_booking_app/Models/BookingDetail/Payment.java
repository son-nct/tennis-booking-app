package com.example.tennis_booking_app.Models.BookingDetail;

import java.util.Date;
import java.util.List;

public class Payment {
    private int id,bookingId,paymentAmount,statusId,userId,insertedBy,updateBy;
    private String refNo;
    private Date insertedDate,updateDate;
    private boolean active;
    List<PaymentDetail> paymentDetail;

    public Payment(int id, int bookingId, int paymentAmount, int statusId, int userId, int insertedBy, int updateBy, String refNo, Date insertedDate, Date updateDate, boolean active, List<PaymentDetail> paymentDetail) {
        this.id = id;
        this.bookingId = bookingId;
        this.paymentAmount = paymentAmount;
        this.statusId = statusId;
        this.userId = userId;
        this.insertedBy = insertedBy;
        this.updateBy = updateBy;
        this.refNo = refNo;
        this.insertedDate = insertedDate;
        this.updateDate = updateDate;
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

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<PaymentDetail> getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(List<PaymentDetail> paymentDetail) {
        this.paymentDetail = paymentDetail;
    }
}
