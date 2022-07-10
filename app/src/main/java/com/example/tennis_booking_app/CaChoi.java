package com.example.tennis_booking_app;

import java.io.Serializable;

public class CaChoi implements Serializable {
    private String slot,thoiluong,gia;
    private int id;

    public CaChoi(int id,String slot, String thoiluong, String gia) {
        this.id=id;
        this.slot = slot;
        this.thoiluong = thoiluong;
        this.gia= gia;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
