package com.example.tennis_booking_app.Models.BookingDetail;

public class BookingDetailRequest {
    private int Id;

    public BookingDetailRequest() {
    }

    public BookingDetailRequest(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
