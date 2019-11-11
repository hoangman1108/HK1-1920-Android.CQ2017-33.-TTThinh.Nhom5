package com.example.ungdungweb_demo;

public class GioHang {
    String tenmon;
    String gia;
    int soluong;
    String hinh;

    public GioHang() {
    }

    public GioHang(String tenmon, String gia, int soluong, String hinh) {
        this.tenmon = tenmon;
        this.gia = gia;
        this.soluong = soluong;
        this.hinh = hinh;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
