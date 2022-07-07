package com.example.tennis_booking_app.Models;

import java.util.List;

public class UserError {
    private List<Token> FullName;
    private List<Token> Username;
    private List<Token> PhoneNumber;

    public UserError(List<Token> fullName, List<Token> username, List<Token> phoneNumber) {
        FullName = fullName;
        Username = username;
        PhoneNumber = phoneNumber;
    }

    public List<Token> getFullName() {
        return FullName;
    }

    public void setFullName(List<Token> fullName) {
        FullName = fullName;
    }

    public List<Token> getUsername() {
        return Username;
    }

    public void setUsername(List<Token> username) {
        Username = username;
    }

    public List<Token> getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(List<Token> phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
