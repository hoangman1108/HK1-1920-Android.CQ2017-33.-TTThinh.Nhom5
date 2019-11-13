package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RequestActivity extends AppCompatActivity {

    ListView list;
    RequestAdapter requestAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        list = findViewById(R.id.list_request);
        requestAdapter = new RequestAdapter(this, R.layout.dia_request,MainActivity.requestXacnhanArrayList);
        list.setAdapter(requestAdapter);


    }
}
