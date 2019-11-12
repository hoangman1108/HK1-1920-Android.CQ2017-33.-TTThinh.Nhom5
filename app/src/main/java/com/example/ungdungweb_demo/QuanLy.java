package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuanLy extends AppCompatActivity {

    Button btnDonHang, btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly);
        btnDonHang = findViewById(R.id.btn_quanly_DonHang);
        btnMenu = findViewById(R.id.btn_quanly_Menu);

        btnDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuanLy.this, XacNhanDonHang.class));
            }
        });

    }
}
