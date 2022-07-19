package com.example.tennis_booking_app;

import java.io.Serializable;

public class VoidcherTest implements Serializable {
    private String tenVoi, maVoi;

    public VoidcherTest(String tenVoi, String maVoi) {
        this.tenVoi = tenVoi;
        this.maVoi = maVoi;
    }

    public String getTenVoi() {
        return tenVoi;
    }

    public void setTenVoi(String tenVoi) {
        this.tenVoi = tenVoi;
    }

    public String getMaVoi() {
        return maVoi;
    }

    public void setMaVoi(String maVoi) {
        this.maVoi = maVoi;
    }
}
