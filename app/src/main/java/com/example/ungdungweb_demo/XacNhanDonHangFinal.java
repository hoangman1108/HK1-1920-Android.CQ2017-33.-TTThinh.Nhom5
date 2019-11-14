package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class XacNhanDonHangFinal extends AppCompatActivity {

    XacNhanAdapter xacNhanAdapter;
    ListView listMon;
    Button btnXacNhan, btnTuChoi;
    Button btnTien, btnCoupon;
    TextView tvTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_don_hang_final);
        listMon = findViewById(R.id.listview_xacnhan_final);
        btnXacNhan = findViewById(R.id.btn_xacnhan);
        btnTuChoi = findViewById(R.id.btn_tuchoi);
        btnTien = findViewById(R.id.btn_xacnhan_tongtien);
        btnCoupon = findViewById(R.id.btn_xacnhan_giamgia);
        tvTien = findViewById(R.id.tv_xacnhan_tongtien);


        Log.d("MANMEO",Dem()+"-"+QuanLy.index);
       xacNhanAdapter = new XacNhanAdapter(this,R.layout.dia_quanly_don_hang,QuanLy.donHangArrayList.get(QuanLy.index).getDonhang());
        listMon.setAdapter(xacNhanAdapter);
        int S = TongTien();
        tvTien.setText(S+".000 đ");
        btnTien.setText(S+".000 đ");
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestXacnhan requestXacnhan = MainActivity.requestXacnhanArrayList.get(QuanLy.index);
                requestXacnhan.request = "xác nhận";
                MainActivity.requestXacnhanArrayList.get(QuanLy.index).request="xác nhận";
                QuanLy.mData.child("RequestDonHang").child(MainActivity.keyRequest.get(QuanLy.index)).setValue(requestXacnhan);
                Log.d("INDEX",QuanLy.index+"");
                Toast.makeText(XacNhanDonHangFinal.this, "xác nhận thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public static int TongTien(){
        int tong = 0;
        String tien ;
        for(int i = 0;i<QuanLy.donHangArrayList.get(QuanLy.index).getDonhang().size();i++){
            tien = "";
            tien = QuanLy.donHangArrayList.get(QuanLy.index).getDonhang().get(i).getGia().toString();
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

    public int Dem(){
        int k = 0;
        for(int i = 0;i<QuanLy.index;i++){
            if(MainActivity.requestXacnhanArrayList.get(i).request.equals("chờ...")){
                k++;
            }
        }
        return k;
    }
}
