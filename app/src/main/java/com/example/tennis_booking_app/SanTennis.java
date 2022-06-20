package com.example.tennis_booking_app;

import java.io.Serializable;

public class SanTennis implements Serializable {
    private String ten,dientich,tien;
    private int hinh;

    public SanTennis(String ten, String dientich, String tien, int hinh) {
        this.ten = ten;
        this.dientich = dientich;
        this.tien = tien;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public String getDientich() {
        return dientich;
    }

    public String getTien() {
        return tien;
    }

    public int getHinh() {
        return hinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDientich(String dientich) {
        this.dientich = dientich;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
