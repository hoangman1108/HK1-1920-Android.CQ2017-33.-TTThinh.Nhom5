package com.example.ungdungweb_demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class MenuMonFragment extends ListFragment {

    MonNuocAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_mon, container, false);

//        monNuocArrayList = new ArrayList<>();

        //listView = getListView();
        AddData();

        adapter = new MonNuocAdapter(getActivity(),R.layout.dialog_mon, MainActivity.monNuocArrayList);
        setListAdapter(adapter);
        return  view;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {

        Toast.makeText(getActivity(), "Honag man"+position, Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }

    void AddData(){
//        monNuocArrayList.add(new MonNuoc("38.000","37.000","Machiato Mango","Machiato co..."));
//        monNuocArrayList.add(new MonNuoc("41.000","35.000","Black coffee","Milk coffee"));
//        monNuocArrayList.add(new MonNuoc("40.000","36.000","Blue sky","Tropical stom"));
//        monNuocArrayList.add(new MonNuoc("55.000","39.000","Hột é","Nước mía"));
//        monNuocArrayList.add(new MonNuoc("37.000","44.000","cocain","red malboro"));
//        monNuocArrayList.add(new MonNuoc("37.000",null,"cocain",null));

    }
}
