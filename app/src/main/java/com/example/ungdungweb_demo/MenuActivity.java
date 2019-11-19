package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    public static ArrayList<String> arrIdMon = new ArrayList<>();
    public static AddMonActivity addMonActivity;
    public static SuaMonNuocAdapter adapter;
    ListView listView;
    public static int keyMon = -1;

    Button btnThem, btnXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnThem = findViewById(R.id.btn_menu_them);
        btnXoa = findViewById(R.id.btn_menu_xoa);

        listView = findViewById(R.id.list_menu);

        Database();
        adapter = new SuaMonNuocAdapter(this,R.layout.dialog_mon, QuanLy.monNuocArrayList);
        listView.setAdapter(adapter);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, AddMonActivity.class));
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, DeleteMonActivity.class));
            }
        });

    }

    public static void Database(){
        adapter = new SuaMonNuocAdapter(addMonActivity,R.layout.dialog_mon, MainActivity.monNuocArrayList);
        QuanLy.monNuocArrayList.clear();
        arrIdMon.clear();
        QuanLy.mData.child("MonNuoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MonNuoc monNuoc = dataSnapshot.getValue(MonNuoc.class);
                QuanLy.monNuocArrayList.add(monNuoc);
                arrIdMon.add(dataSnapshot.getKey());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MonNuoc monNuoc = dataSnapshot.getValue(MonNuoc.class);
                QuanLy.monNuocArrayList.add(monNuoc);
                adapter.notifyDataSetChanged();
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
