package com.example.ungdungweb_demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class MenuMonFragment extends ListFragment {
    ArrayList<MonNuoc> monNuocArrayList;
    MonNuocAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_mon, container, false);
        monNuocArrayList = new ArrayList<>();
        monNuocArrayList.add(new MonNuoc("38.000","37000","Machiato Mango","Machiato co..."));
        monNuocArrayList.add(new MonNuoc("41.000","35000","Black coffee","Milk coffee"));
        monNuocArrayList.add(new MonNuoc("40.000","36000","Blue sky","Tropical stom"));
        monNuocArrayList.add(new MonNuoc("55.000","39000","Hột é","Nước mía"));
        monNuocArrayList.add(new MonNuoc("37.000","44000","cocain","red malboro"));


        adapter = new MonNuocAdapter(getActivity(),R.layout.mon, monNuocArrayList);
        setListAdapter(adapter);
        return  view;
    }
}
