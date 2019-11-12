package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class XacNhanDonHang extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView lvdonhang;
    ArrayList<String> arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_don_hang);
        lvdonhang = findViewById(R.id.lv_quanly_donhang);

        arr = new ArrayList<>();

        MainActivity.mData.child("DonHang").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Log.d("aa",dataSnapshot.getChildrenCount()+"");
//                DonHang donHang = dataSnapshot.getValue(DonHang.class);
//                Log.d("DDD",donHang.getSdt());
                MainActivity.donHangArrayList.add(dataSnapshot.getValue(DonHang.class));
                Log.d("DDD",MainActivity.gioHangArrayList.size()+"");
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
        Log.d("AAA",MainActivity.donHangArrayList.size()+"");

        for(int i = 0;i<MainActivity.donHangArrayList.size();i++){
            arr.add("Có đơn hàng từ sđt: "+MainActivity.donHangArrayList.get(i).getSdt());
            Log.d("BBB",MainActivity.donHangArrayList.get(i).getSdt());
        }
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arr);
        lvdonhang.setAdapter(adapter);

    }
}
