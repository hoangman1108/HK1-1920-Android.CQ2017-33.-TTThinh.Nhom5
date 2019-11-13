package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class XacNhanDonHang extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView lvdonhang;
    ArrayList<String> arr;
    ThongTinDonAdapter thongTinDonAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_don_hang);
        lvdonhang = findViewById(R.id.lv_quanly_donhang);

        arr = new ArrayList<>();


        for(int i = 0;i<QuanLy.donHangArrayList.size();i++){
            arr.add("Có đơn hàng từ sđt: "+QuanLy.donHangArrayList.get(i).getSdt());
        }

        thongTinDonAdapter = new ThongTinDonAdapter(this, R.layout.dia_thongtin_nhan_don_hang,QuanLy.donHangArrayList);

//        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arr);
        lvdonhang.setAdapter(thongTinDonAdapter);
//        adapter.notifyDataSetChanged();

        lvdonhang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QuanLy.index = position;
                startActivity(new Intent(XacNhanDonHang.this, XacNhanDonHangFinal.class));
            }
        });

//        QuanLy.mData.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    adapter.clear();
//                    for(int i = 0;i<QuanLy.donHangArrayList.size();i++){
//                        adapter.add("Có đơn hàng từ sđt: "+QuanLy.donHangArrayList.get(i).getSdt());
//                    }
//                    adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

    }
}
