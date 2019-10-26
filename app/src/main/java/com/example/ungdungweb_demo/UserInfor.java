package com.example.ungdungweb_demo;

public class UserInfor {

    public UserInfor (String email, String phone, String password) {
        this.Email = email;
        this.Password = password;
        this.Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    private String Email, Phone, Password;
}
