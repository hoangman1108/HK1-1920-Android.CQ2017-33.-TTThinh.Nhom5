package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RequestActivity extends AppCompatActivity {

    ListView list;
    RequestAdapter requestAdapter;
    ArrayList<RequestXacnhan> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        arrayList = new ArrayList<>();
        for(int i = 0;i<MainActivity.requestXacnhanArrayList.size();i++)
        if(MainActivity.requestXacnhanArrayList.get(i).sdt.equals(MainActivity.userInforArrayList.get(MainActivity.index).getPhone())){
            arrayList.add(MainActivity.requestXacnhanArrayList.get(i));
        }

        list = findViewById(R.id.list_request);
        requestAdapter = new RequestAdapter(this, R.layout.dia_request,arrayList);
        list.setAdapter(requestAdapter);


    }
}
