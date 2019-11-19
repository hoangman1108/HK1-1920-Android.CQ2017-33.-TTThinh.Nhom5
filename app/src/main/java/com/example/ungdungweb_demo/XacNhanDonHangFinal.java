package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        btnTuChoi = findViewById(R.id.btn_xacnhan_tuchoi);
        btnTien = findViewById(R.id.btn_xacnhan_tongtien);
        btnCoupon = findViewById(R.id.btn_xacnhan_giamgia);
        tvTien = findViewById(R.id.tv_xacnhan_tongtien);


//        xacNhanAdapter = new XacNhanAdapter(this,R.layout.dia_quanly_don_hang,QuanLy.donHangArrayList.get(QuanLy.index).getDonhang());
        xacNhanAdapter = new XacNhanAdapter(this,R.layout.dia_quanly_don_hang,XacNhanDonHang.hangArrayList.get(QuanLy.index).getDonhang());
        listMon.setAdapter(xacNhanAdapter);
        int S = TongTien();
        tvTien.setText(S+".000 đ");
        btnTien.setText(S+".000 đ");
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestXacnhan requestXacnhan = MainActivity.requestXacnhanArrayList.get(Dem());
                if(QuanLy.xacdinhmandatarequest == 1){
                    requestXacnhan.request = "xác nhận";
                    MainActivity.requestXacnhanArrayList.get(Dem()).request="xác nhận";
                }else if(QuanLy.xacdinhmandatarequest == 2){
                    requestXacnhan.request = "đã thanh toán";
                    MainActivity.requestXacnhanArrayList.get(Dem()).request="đã thanh toán";
                    DoanhThu doanhThu = new DoanhThu(requestXacnhan.time,btnTien.getText().toString(),requestXacnhan.sdt);
                    QuanLy.mData.child("DoanhThu").push().setValue(doanhThu);

                }
                QuanLy.mData.child("RequestDonHang").child(MainActivity.keyRequest.get(Dem())).setValue(requestXacnhan);
                Toast.makeText(XacNhanDonHangFinal.this, "xác nhận thành công", Toast.LENGTH_SHORT).show();
                MainActivity.LoadKeyGioHang();
                finish();
            }
        });

        btnTuChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestXacnhan requestXacnhan = MainActivity.requestXacnhanArrayList.get(Dem());
                if(QuanLy.xacdinhmandatarequest == 1){
                    requestXacnhan.request = "từ chối";
                    MainActivity.requestXacnhanArrayList.get(Dem()).request="từ chối";
                }else if(QuanLy.xacdinhmandatarequest == 2){
                   finish();

                }
                QuanLy.mData.child("RequestDonHang").child(MainActivity.keyRequest.get(Dem())).setValue(requestXacnhan);
                Toast.makeText(XacNhanDonHangFinal.this, "xác nhận thành công", Toast.LENGTH_SHORT).show();
                MainActivity.LoadKeyGioHang();
                finish();
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
        for(int i = 0;i<MainActivity.requestXacnhanArrayList.size();i++){
            if(MainActivity.requestXacnhanArrayList.get(i).time.equals(XacNhanDonHang.hangArrayList.get(QuanLy.index).getTime())){
                return i;
            }
        }
        return -1;
    }
}
