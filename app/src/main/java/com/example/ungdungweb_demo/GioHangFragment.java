package com.example.ungdungweb_demo;

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
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class GioHangFragment extends ListFragment{

    public static GioHangAdapter adaptergiohang;

    public static TextView tvTongTien;
    Button btnGiamGia;
    public static Button btnTongTien;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giohang,container,false);

        tvTongTien = view.findViewById(R.id.tv_fragment_giohang_tongtien);
        btnTongTien = view.findViewById(R.id.btn_fragment_giohang_tongtien);
        btnGiamGia = view.findViewById(R.id.btn_fragment_giohang_giamgia);
        adaptergiohang = new GioHangAdapter(getActivity(),R.layout.dia_don_hang,MainActivity.gioHangArrayList);

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


        return view;
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
