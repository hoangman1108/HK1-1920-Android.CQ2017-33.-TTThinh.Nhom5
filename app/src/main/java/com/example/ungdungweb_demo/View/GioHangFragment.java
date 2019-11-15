package com.example.ungdungweb_demo.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.ungdungweb_demo.Coupon;
import com.example.ungdungweb_demo.DonHang;
import com.example.ungdungweb_demo.GioHangAdapter;
import com.example.ungdungweb_demo.R;
import com.example.ungdungweb_demo.RequestXacnhan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GioHangFragment extends ListFragment{

    public static GioHangAdapter adaptergiohang;

    public static TextView tvTongTien;
    Button btnGiamGia, btnXacNhan;
    public static Button btnTongTien;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giohang,container,false);

        tvTongTien = view.findViewById(R.id.tv_fragment_giohang_tongtien);
        btnTongTien = view.findViewById(R.id.btn_fragment_giohang_tongtien);
        btnGiamGia = view.findViewById(R.id.btn_fragment_giohang_giamgia);
        btnXacNhan = view.findViewById(R.id.btn_xacnhandachangfinal);
        adaptergiohang = new GioHangAdapter(getActivity(),R.layout.dia_don_hang, MainActivity.gioHangArrayList);
        setListAdapter(adaptergiohang);


        tvTongTien.setText(TongTien()+".000 đ");
        btnTongTien.setText(TongTien()+".000 đ");
        btnGiamGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Coupon.class);
                startActivity(intent);
            }
        });

        if(MainActivity.gioHangArrayList.isEmpty()){
            btnXacNhan.setClickable(false);
        }
        else {
            btnXacNhan.setClickable(true);
            btnXacNhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DonHang donHang = new DonHang();
                    String temp = MainActivity.userInforArrayList.get(MainActivity.index).getPhone();
                    donHang.setSdt(temp);
                    donHang.setDonhang(MainActivity.gioHangArrayList);
                    donHang.setTime(getDateTime());
                    MainActivity.mData.child("DonHang").push().setValue(donHang);
                    Toast.makeText(getActivity(), "Thành Công", Toast.LENGTH_SHORT).show();
                    MainActivity.gioHangArrayList.clear();



                    RequestXacnhan requestXacnhan = new RequestXacnhan(MainActivity.userInforArrayList.get(MainActivity.index).getPhone(),"chờ...",getDateTime());
                    MainActivity.mData.child("RequestDonHang").push().setValue(requestXacnhan);

                    MainActivity.navigationView.setCheckedItem(R.id.itemGioHang);
                    Fragment fragment = new GioHangFragment();
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).show(fragment).commit();
                }
            });
        }

        return view;
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static int TongTien(){
        int tong = 0;
        String tien ;
        for(int i = 0;i<MainActivity.gioHangArrayList.size();i++){
            tien = "";
            tien = MainActivity.gioHangArrayList.get(i).getGia().toString();
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

}
