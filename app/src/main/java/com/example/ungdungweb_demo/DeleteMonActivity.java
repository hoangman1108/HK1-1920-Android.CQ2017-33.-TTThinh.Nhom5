package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class DeleteMonActivity extends AppCompatActivity {

    DeleteMonAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_mon);
        listView = findViewById(R.id.list_xoamon);
        adapter = new DeleteMonAdapter(this,R.layout.dia_xoa_mon,QuanLy.monNuocArrayList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DeleteMonActivity.this, MenuActivity.class));
        finish();
    }
}
