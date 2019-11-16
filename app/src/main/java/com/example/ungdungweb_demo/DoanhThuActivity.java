package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ungdungweb_demo.DoanhThu;
import com.example.ungdungweb_demo.DoanhThuAdapter;
import com.example.ungdungweb_demo.QuanLy;
import com.example.ungdungweb_demo.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DoanhThuActivity extends AppCompatActivity {

    DoanhThuAdapter adapter;
    ListView listView;
    Button btnTongTien, btnreset;
    ArrayList<DoanhThu> doanhThuArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doanh_thu);
        listView = findViewById(R.id.list_doanhthu);
        btnTongTien = findViewById(R.id.btn_tong_doanh_thu);
        btnreset =findViewById(R.id.btn_resetDoanhThu);

        DatabaseDoanhThu();
        adapter = new DoanhThuAdapter(this,R.layout.dia_pos_doanhthu,doanhThuArrayList);
        listView.setAdapter(adapter);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuanLy.mData.child("DoanhThu").removeValue();
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
    }

    public int TongTien(){
        int tong = 0;
        String tien ;
        for(int i = 0;i<doanhThuArrayList.size();i++){
            tien = "";
            tien = doanhThuArrayList.get(i).Tien;
            tien = getStringTien(tien);
            tong += Integer.parseInt(tien);

        }
        return tong;
    }

    public static String getStringTien(String tien){
        String temp = "";
        for(int i = 0;i<tien.length();i++){
            if(tien.charAt(i) =='.') {
                break;
            }
            temp+=tien.charAt(i);
        }
        return temp;
    }

   private void DatabaseDoanhThu(){
        doanhThuArrayList.clear();
        QuanLy.mData.child("DoanhThu").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DoanhThu doanhThu = dataSnapshot.getValue(DoanhThu.class);
                doanhThuArrayList.add(doanhThu);
                btnTongTien.setText("Tổng thu nhập: "+TongTien()+".000 đ");
                adapter.notifyDataSetChanged();
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
}
