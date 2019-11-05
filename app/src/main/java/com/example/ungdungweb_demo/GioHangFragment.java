package com.example.ungdungweb_demo;

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

    GioHangAdapter adapter;

    TextView tvTongTien;
    Button btnTongTien;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giohang,container,false);

        tvTongTien = view.findViewById(R.id.tv_fragment_giohang_tongtien);
        btnTongTien = view.findViewById(R.id.btn_fragment_giohang_tongtien);
        adapter = new GioHangAdapter(getActivity(),R.layout.dia_don_hang,MainActivity.gioHangArrayList);
//        MainActivity.gioHangArrayList.add(new GioHang("Hồng trà mật ong","45.000 đ",1));
        setListAdapter(adapter);
        tvTongTien.setText(TongTien()+".000 đ");
        btnTongTien.setText(TongTien()+".000 đ");
        return view;
    }

    public int TongTien(){
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

    private String getStringTien(String tien){
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
