package com.example.tennis_booking_app.Models;

import java.io.Serializable;
import java.util.Date;

public class SlotCourtValue implements Serializable {
    private int id;
    private int slotId;
    private int courtId;
    private Date insertedDate;
    private int insertedBy;
    private Date updatedDate;
    private int updatedBy;
    private boolean active;

    public SlotCourtValue(int id, int slotId, int courtId, Date insertedDate, int insertedBy, Date updatedDate, int updatedBy, boolean active) {
        this.id = id;
        this.slotId = slotId;
        this.courtId = courtId;
        this.insertedDate = insertedDate;
        this.insertedBy = insertedBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
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
}
