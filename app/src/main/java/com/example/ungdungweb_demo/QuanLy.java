package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class QuanLy extends AppCompatActivity {
    public static int index = -1;
    public static int xacdinhmandatarequest = -1;
    public static ArrayList<DonHang> donHangArrayList = new ArrayList<>();
    public static DatabaseReference mData = FirebaseDatabase.getInstance().getReference();
    public static ArrayList<String> arraykey = new ArrayList<>();
    public static ArrayList<MonNuoc> monNuocArrayList = new ArrayList<>();
    Button btnDonHang, btnMenu, btnXacnhan, btnDoanhthu,btnDangxuat, btnDoimk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly);
        btnDonHang = findViewById(R.id.btn_quanly_DonHang);
        btnMenu = findViewById(R.id.btn_quanly_Menu);
        btnXacnhan = findViewById(R.id.btn_quanly_daxacnhan);
        btnDoanhthu = findViewById(R.id.btn_quanly_doanhthu);
        btnDangxuat = findViewById(R.id.btn_quanly_dangxuat);
        btnDoimk = findViewById(R.id.btn_quanly_doimk);


        DataBase();
//        Value value = new Value(0,"");
        btnDoimk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuanLy.this, ChangePassword.class));
            }
        });

        btnDoanhthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuanLy.this, DoanhThuActivity.class));
            }
        });

        btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.index=-1;
                startActivity(new Intent(QuanLy.this,LoginActivity.class));
                finish();
            }
        });

        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuanLy.xacdinhmandatarequest = 2;
                Intent intent = new Intent(QuanLy.this, XacNhanDonHang.class);
                startActivity(intent);
            }
        });

        btnDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuanLy.xacdinhmandatarequest = 1;
                Intent intent = new Intent(QuanLy.this, XacNhanDonHang.class);
                startActivity(intent);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuanLy.this, MenuActivity.class));
                finish();
            }
        });


    }

    public static void DataBase(){
        donHangArrayList.clear();
        mData.child("DonHang").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                donHangArrayList.add(dataSnapshot.getValue(DonHang.class));
                arraykey.add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public static void DataBaseXacNhan(){
        donHangArrayList.clear();
        mData.child("DonHang").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                donHangArrayList.add(dataSnapshot.getValue(DonHang.class));
                arraykey.add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivity.index = -1;
    }
}
