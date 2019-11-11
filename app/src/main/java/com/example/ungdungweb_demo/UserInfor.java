package com.example.ungdungweb_demo;

public class UserInfor {
    public UserInfor() {
    }

    public UserInfor(String email, String phone, String password, String name, String date, String gender) {
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.date = date;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String email;
    public String phone;
    public String password;
    public String name;
    public String date;
    public String gender;
}
