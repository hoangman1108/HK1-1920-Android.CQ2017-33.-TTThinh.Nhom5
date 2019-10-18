package com.example.ungdungweb_demo;

public class MonNuoc {

    String Gia;

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public MonNuoc(String gia, String tenMon) {
        Gia = gia;
        TenMon = tenMon;
    }

    String TenMon;
}
