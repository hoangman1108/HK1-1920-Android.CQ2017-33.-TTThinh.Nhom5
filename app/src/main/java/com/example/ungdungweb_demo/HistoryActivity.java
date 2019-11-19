package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ListView list;
     RequestAdapter requestAdapter;ArrayList<RequestXacnhan> arrayList;
    ArrayList<String> key = new ArrayList<>();
    ArrayList<String> key_all = new ArrayList<>();
    ArrayList<String> key_history = new ArrayList<>();

    Button btnReset;
    TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        arrayList = new ArrayList<>();
//        MainActivity.DataBase();
//        MainActivity.LoadKeyGioHang();

        for(int i = 0;i<MainActivity.requestXacnhanArrayList.size();i++)
        {
            arrayList.clear();
            key_history.clear();
            key.clear();

            if(MainActivity.requestXacnhanArrayList.get(i).sdt.equals(MainActivity.userInforArrayList.get(MainActivity.index).getPhone())){
                if(MainActivity.requestXacnhanArrayList.get(i).request.equals("đã thanh toán") || MainActivity.requestXacnhanArrayList.get(i).request.equals("từ chối"))
                {
                    arrayList.add(MainActivity.requestXacnhanArrayList.get(i));
                    key.add(MainActivity.keyRequest.get(i));
                    key_history.add(MainActivity.keygiohang.get(i));
                }
                else {
                    key_all.add(MainActivity.keyRequest.get(i));
                }
            }
        }

//        list = findViewById(R.id.list_request);
//        requestAdapter = new RequestAdapter(this, R.layout.dia_request,arrayList);
//        list.setAdapter(requestAdapter);

            list = findViewById(R.id.list_request);
            tvName = findViewById(R.id.tv_changenamerequest);
//            btnReset.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int k = key.size();
//                    for(int i = 0;i<k;i++){
//                        QuanLy.mData.child("RequestDonHang").child(key.get(i)).removeValue();
//                    }
//                    arrayList.clear();
//                    requestAdapter.notifyDataSetChanged();
//
//                }
//            });
            tvName.setText("History");
            requestAdapter = new RequestAdapter(this, R.layout.dia_request, arrayList);
            list.setAdapter(requestAdapter);

//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int k = key.size();
//                if(k != 0){
//                    for(int i = 0;i<k;i++)
//                    {
//
//                        QuanLy.mData.child("RequestDonHang").child(key.get(i)).removeValue();
//                        QuanLy.mData.child("DonHang").child(key_history.get(i)).removeValue();
//                    }
//                    arrayList.clear();
//                    key_history.clear();
//                    key.clear();
//                    requestAdapter.notifyDataSetChanged();
//
//                }
//            }
//        });

        for (int i = 0; i < key_all.size(); i++) {
            final int finalI = i;
//            arrayList.clear();

            QuanLy.mData.child("RequestDonHang").child(key_all.get(i)).child("request").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    MainActivity.DataBase();
//                    MainActivity.LoadKeyGioHang();
                    if(dataSnapshot.getValue().equals("đã thanh toán")){
                        for(int i = 0;i<MainActivity.requestXacnhanArrayList.size();i++)
                        {
                            if(MainActivity.requestXacnhanArrayList.get(i).sdt.equals(MainActivity.userInforArrayList.get(MainActivity.index).getPhone())){
                                if(MainActivity.requestXacnhanArrayList.get(i).request.equals("đã thanh toán"))
                                {
                                    arrayList.add(MainActivity.requestXacnhanArrayList.get(i));
                                    key.add(MainActivity.keyRequest.get(i));
                                    key_history.add(MainActivity.keygiohang.get(i));
                                }
                            }
                            requestAdapter.notifyDataSetChanged();

                        }
//                        arrayList.get(finalI).request = (String) dataSnapshot.getValue();
//                        arrayList.add(QuanLy.mData.child("RequestDonHang").child(key.get(finalI)))

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
    }
}
