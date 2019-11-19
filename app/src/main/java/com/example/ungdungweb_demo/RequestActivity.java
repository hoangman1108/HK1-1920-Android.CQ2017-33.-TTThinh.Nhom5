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
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.Change;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RequestActivity extends AppCompatActivity {

    int a = 0;
    TextView tvName;
    ListView list;
    Button btnReset;
    RequestAdapter requestAdapter;
    ArrayList<String> key = new ArrayList<>();
    ArrayList<String> key_giohang = new ArrayList<>();
    ArrayList<RequestXacnhan> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        arrayList= new ArrayList<>();
        arrayList.clear();
        key_giohang.clear();
        key.clear();
        for (int i = 0; i < MainActivity.requestXacnhanArrayList.size(); i++) {
            if (MainActivity.requestXacnhanArrayList.get(i).sdt.equals(MainActivity.userInforArrayList.get(MainActivity.index).getPhone())) {
                if (!MainActivity.requestXacnhanArrayList.get(i).request.equals("đã thanh toán")) {
                    arrayList.add(MainActivity.requestXacnhanArrayList.get(i));
                    key.add(MainActivity.keyRequest.get(i));
                    key_giohang.add(MainActivity.keygiohang.get(i));
                }
            }
        }
        tvName = findViewById(R.id.tv_changenamerequest);
        tvName.setText("Thông báo");
        list = findViewById(R.id.list_request);

        requestAdapter = new RequestAdapter(this, R.layout.dia_request, arrayList);
        list.setAdapter(requestAdapter);
//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                a = 1;
//                int k = key.size();
//                if(k >0)
//                {
//                    for (int i = 0; i < k; i++) {
//                        QuanLy.mData.child("RequestDonHang").child(key.get(i)).removeValue();
//                        QuanLy.mData.child("DonHang").child(key_giohang.get(i)).removeValue();
//                    }
//                }
//                arrayList.clear();
//                key_giohang.clear();
//                key.clear();
//                requestAdapter.notifyDataSetChanged();
//
//            }
//        });



//        QuanLy.mData.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                MainActivity.DataBase();
//                MainActivity.LoadKeyGioHang();
//                requestAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        if(a !=1)
//        {
        for (int i = 0; i < key.size(); i++) {
            final int finalI = i;
//            arrayList.clear();
            QuanLy.mData.child("RequestDonHang").child(key.get(i)).child("request").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    MainActivity.DataBase();
//                    MainActivity.LoadKeyGioHang();
                    if(dataSnapshot.getValue().equals("chờ...") || dataSnapshot.getValue().equals("xác nhận")){
                        arrayList.get(finalI).request = (String) dataSnapshot.getValue();
                    } else
                    {
                        arrayList.get(finalI).request = (String) dataSnapshot.getValue();
                        if(arrayList.size() == 1){
                            arrayList.clear();
                        }else{
                            arrayList.remove(finalI);
                        }
                    }
                    requestAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
//        }
//
//        }
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(new Intent(RequestActivity.this,MainActivity.class)));
//        finish();
//    }

    //    public static void DataRequest(){
//        arrayList.clear();
//        key.clear();
//        key_giohang.clear();
//        for(int i = 0; i< MainActivity.requestXacnhanArrayList.size(); i++)
//        {
//            if(MainActivity.requestXacnhanArrayList.get(i).sdt.equals(MainActivity.userInforArrayList.get(MainActivity.index).getPhone())){
//                if(!MainActivity.requestXacnhanArrayList.get(i).request.equals("đã thanh toán"))
//                {
//                    arrayList.add(MainActivity.requestXacnhanArrayList.get(i));
//                    key.add(MainActivity.keyRequest.get(i));
//                    key_giohang.add(MainActivity.keygiohang.get(i));
//                }
//            }
//        }
//    }

}
