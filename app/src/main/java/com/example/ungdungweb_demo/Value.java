package com.example.ungdungweb_demo;

public class Value {
    int value;
    String keyMon;

    public Value() {
    }

    public Value(int value, String keyMon) {
        this.value = value;
        this.keyMon = keyMon;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKeyMon() {
        return keyMon;
    }

    public void setKeyMon(String keyMon) {
        this.keyMon = keyMon;
    }
}
