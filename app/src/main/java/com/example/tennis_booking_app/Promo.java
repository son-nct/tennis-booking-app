package com.example.tennis_booking_app;

import java.io.Serializable;

public class Promo implements Serializable {
    private String ten,mota,cuthe;
    private int hinh;

    public Promo(String ten, String mota, String cuthe, int hinh) {
        this.ten = ten;
        this.mota = mota;
        this.cuthe = cuthe;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getCuthe() {
        return cuthe;
    }

    public void setCuthe(String cuthe) {
        this.cuthe = cuthe;
    }
}
