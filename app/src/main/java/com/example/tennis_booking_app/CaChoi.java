package com.example.tennis_booking_app;

import java.io.Serializable;

public class CaChoi implements Serializable {
    private String slot,thoiluong,gia;
    private boolean cb;

    public CaChoi(String slot, String thoiluong, String gia) {
        this.slot = slot;
        this.thoiluong = thoiluong;
        this.gia= gia;
    }

    public String getSlot() {
        return slot;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public String getGia() {
        return gia;
    }
    public boolean isCb() {
        return cb;
    }

    public void setCb(boolean cb) {
        this.cb = cb;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
