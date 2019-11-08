package com.example.ungdungweb_demo;

public class UserInfor {
    public UserInfor(String email, String phone, String password, String name, String date, String gender) {
        Email = email;
        Phone = phone;
        Password = password;
        Name = name;
        Date = date;
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    private String Email, Phone, Password;
    private String Name, Date, Gender;
}
