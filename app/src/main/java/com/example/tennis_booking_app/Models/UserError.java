package com.example.tennis_booking_app.Models;

import java.util.List;

public class UserError {
    private String[] FullName;
    private String[] Username;
    private String[] PhoneNumber;

    public UserError(String[] fullName, String[] username, String[] phoneNumber) {
        FullName = fullName;
        Username = username;
        PhoneNumber = phoneNumber;
    }

    public String[] getFullName() {
        return FullName;
    }

    public void setFullName(String[] fullName) {
        FullName = fullName;
    }

    public String[] getUsername() {
        return Username;
    }

    public void setUsername(String[] username) {
        Username = username;
    }

    public String[] getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String[] phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
