package com.example.ungdungweb_demo;

public class MonNuoc {
    public MonNuoc(String Gia1, String Gia2, String tenMon1, String tenMon2, String Hinh1, String Hinh2) {
        gia1 = Gia1;
        gia2 = Gia2;
        tenmon1 = tenMon1;
        tenmon2 = tenMon2;
        hinh1 = Hinh1;
        hinh2 = Hinh2;
    }

    public MonNuoc(String gia1, String tenmon1, String Hinh1) {
        this.gia1 = gia1;
        this.tenmon1 = tenmon1;
        this.hinh1 = Hinh1;
    }

    public MonNuoc() {
    }

    public String getGia1() {
        return gia1;
    }

    public void setGia1(String Gia1) {
        gia1 = Gia1;
    }

    public String getGia2() {
        return gia2;
    }

    public void setGia2(String Gia2) {
        gia2 = Gia2;
    }

    public String getTenMon1() {
        return tenmon1;
    }

    public void setTenMon1(String tenMon1) {
        tenmon1 = tenMon1;
    }

    public String getTenMon2() {
        return tenmon2;
    }

    public void setTenMon2(String tenMon2) {
        tenmon2 = tenMon2;
    }

    public void setHinh1(String Hinh1){
        hinh1 = Hinh1;
    }
    public String getHinh1(){
        return hinh1;
    }

    public void setHinh2(String Hinh2){
        hinh2 = Hinh2;
    }
    public String getHinh2(){
        return hinh2;
    }

    String hinh1, hinh2;
    String gia1, gia2;
    String tenmon1, tenmon2;
}
