package com.example.tennis_booking_app;

import java.io.Serializable;

public class SanKM implements Serializable {
    private String ten,dientich,tien, promoCode, rating, khoangCach;
    private int hinh;

    public SanKM(String ten, String dientich, String tien, String promoCode, int hinh, String rating, String khoangCach) {
        this.ten = ten;
        this.dientich = dientich;
        this.tien = tien;
        this.promoCode = promoCode;
        this.hinh = hinh;
        this.rating = rating;
        this.khoangCach = khoangCach;
    }

    public String getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(String khoangCach) {
        this.khoangCach = khoangCach;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
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
