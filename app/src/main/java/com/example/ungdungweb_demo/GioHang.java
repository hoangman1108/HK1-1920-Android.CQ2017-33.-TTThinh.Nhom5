package com.example.ungdungweb_demo;

public class GioHang {
    String tenMon;
    String Gia;
    int SoLuong;

    public GioHang(String tenMon, String gia, int soLuong) {
        this.tenMon = tenMon;
        Gia = gia;
        SoLuong = soLuong;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
