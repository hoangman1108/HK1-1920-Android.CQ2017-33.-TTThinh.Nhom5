package com.example.ungdungweb_demo;

import java.util.ArrayList;
import java.util.List;

public class DonHang {

    ArrayList<GioHang> donhang;
    String sdt;

    public DonHang(ArrayList<GioHang> donhang, String sdt) {
        this.donhang = donhang;
        this.sdt = sdt;
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
