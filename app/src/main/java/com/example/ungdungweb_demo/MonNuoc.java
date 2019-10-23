package com.example.ungdungweb_demo;

public class MonNuoc {
    public MonNuoc(String gia1, String gia2, String tenMon1, String tenMon2) {
        Gia1 = gia1;
        Gia2 = gia2;
        TenMon1 = tenMon1;
        TenMon2 = tenMon2;
    }

    public String getGia1() {
        return Gia1;
    }

    public void setGia1(String gia1) {
        Gia1 = gia1;
    }

    public String getGia2() {
        return Gia2;
    }

    public void setGia2(String gia2) {
        Gia2 = gia2;
    }

    public String getTenMon1() {
        return TenMon1;
    }

    public void setTenMon1(String tenMon1) {
        TenMon1 = tenMon1;
    }

    public String getTenMon2() {
        return TenMon2;
    }

    public void setTenMon2(String tenMon2) {
        TenMon2 = tenMon2;
    }

    String Gia1, Gia2;
    String TenMon1, TenMon2;
}
