package com.example.tennis_booking_app.PhucHLH.CourtDiscount;

public class CourtDiscount {

    private String courtName;
    private String priceBefore;
    private String priceAfter;
    private int courtImage;

    public CourtDiscount(String courtName, String priceBefore, String priceAfter, int courtImage) {
        this.courtName = courtName;
        this.priceBefore = priceBefore;
        this.priceAfter = priceAfter;
        this.courtImage = courtImage;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(String priceBefore) {
        this.priceBefore = priceBefore;
    }

    public String getPriceAfter() {
        return priceAfter;
    }

    public void setPriceAfter(String priceAfter) {
        this.priceAfter = priceAfter;
    }

    public int getCourtImage() {
        return courtImage;
    }

    public void setCourtImage(int courtImage) {
        this.courtImage = courtImage;
    }
}
