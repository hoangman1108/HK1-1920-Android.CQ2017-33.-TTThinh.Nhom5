package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ungdungweb_demo.View.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class XacNhanDonHang extends AppCompatActivity {

    public static ArrayList<Integer> arraykeyXacnhan = new ArrayList<>();
    ListView lvdonhang;
    ArrayList<String> arr;
    ThongTinDonAdapter thongTinDonAdapter;
    public static ArrayList<DonHang> hangArrayList = new ArrayList<>();
    int m = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_don_hang);
        lvdonhang = findViewById(R.id.lv_quanly_donhang);

        arr = new ArrayList<>();

        AddListBase();
        thongTinDonAdapter = new ThongTinDonAdapter(this, R.layout.dia_thongtin_nhan_don_hang,hangArrayList);

        lvdonhang.setAdapter(thongTinDonAdapter);

        lvdonhang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QuanLy.index = position;
                startActivity(new Intent(XacNhanDonHang.this, XacNhanDonHangFinal.class));
            }
        });


        QuanLy.mData.child("RequestDonHang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    AddListBase();
                    thongTinDonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void AddListBase(){
        hangArrayList.clear();
        String temp = "";
        if(QuanLy.xacdinhmandatarequest == 1){
            temp = "chờ...";
        }else if(QuanLy.xacdinhmandatarequest == 2){
            temp = "xác nhận";
        }
        for(int i = 0;i<QuanLy.donHangArrayList.size();i++){
            if(MainActivity.requestXacnhanArrayList.get(i).request.equals(temp)){
                hangArrayList.add(QuanLy.donHangArrayList.get(i));
            }
        }
    }

}
