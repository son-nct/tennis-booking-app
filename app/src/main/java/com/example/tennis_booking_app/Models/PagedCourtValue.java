package com.example.tennis_booking_app.Models;

import java.util.Date;

public class PagedCourtValue {
    private int id;
    private String name;
    private int vendorId;
    private int typeId;
    private int courtSizeId;
    private Date insertedDate;
    private int insertedBy;
    private Date updatedDate;
    private int updatedBy;
    private boolean active;
    private int ratingAverage;
    private String imageUrl;

    public PagedCourtValue(int id, String name, int vendorId, int typeId, int courtSizeId, Date insertedDate, int insertedBy, Date updatedDate, int updatedBy, boolean active, int ratingAverage, String imageUrl) {
        this.id = id;
        this.name = name;
        this.vendorId = vendorId;
        this.typeId = typeId;
        this.courtSizeId = courtSizeId;
        this.insertedDate = insertedDate;
        this.insertedBy = insertedBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.active = active;
        this.ratingAverage = ratingAverage;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getCourtSizeId() {
        return courtSizeId;
    }

    public void setCourtSizeId(int courtSizeId) {
        this.courtSizeId = courtSizeId;
    }

    public Date getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        this.insertedDate = insertedDate;
    }

    public int getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        this.insertedBy = insertedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(int ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
