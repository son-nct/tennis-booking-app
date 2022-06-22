package com.example.tennis_booking_app;

public class PromoClass {
    private int hinh,sao,the;
    private String tenSan,khoangCach,promo,maKM;

    public PromoClass(int hinh, int sao, int the, String promo, String tenSan, String khoangCach, String maKM) {
        this.hinh = hinh;
        this.sao = sao;
        this.the = the;
        this.maKM = maKM;
        this.tenSan = tenSan;
        this.khoangCach = khoangCach;
        this.promo = promo;
    }

    public int getHinh() {
        return hinh;
    }

    public int getSao() {
        return sao;
    }

    public int getThe() {
        return the;
    }

    public String getMaKM() {
        return maKM;
    }

    public String getTenSan() {
        return tenSan;
    }

    public String getKhoangCach() {
        return khoangCach;
    }

    public String getPromo() {
        return promo;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public void setThe(int the) {
        this.the = the;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public void setKhoangCach(String khoangCach) {
        this.khoangCach = khoangCach;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }
}
