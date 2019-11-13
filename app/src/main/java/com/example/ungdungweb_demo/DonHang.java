package com.example.ungdungweb_demo;

import java.util.ArrayList;
import java.util.List;

public class DonHang {

    ArrayList<GioHang> donhang;
    String sdt;
    String time;

    public DonHang(ArrayList<GioHang> donhang, String sdt, String time) {
        this.donhang = donhang;
        this.sdt = sdt;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<GioHang> getDonhang() {
        return donhang;
    }

    public void setDonhang(ArrayList<GioHang> donhang) {
        this.donhang = donhang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public DonHang() {
    }
}
