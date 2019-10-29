package com.example.ungdungweb_demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class GioHangFragment extends ListFragment{

    GioHangAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giohang,container,false);
        adapter = new GioHangAdapter(getActivity(),R.layout.dia_don_hang,MainActivity.gioHangArrayList);
//        MainActivity.gioHangArrayList.add(new GioHang("Hồng trà mật ong","45.000 đ",1));
        setListAdapter(adapter);
        return view;
    }




}
