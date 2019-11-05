package com.example.ungdungweb_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {
    ImageButton btnDatHang, btnCoupon, btnTichDiem, btnDiaChi;
    private ImageView imgbtAva;
    public MainActivity mainActivity;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        btnDatHang = view.findViewById(R.id.btn_fragment_main_DatHang);
        btnCoupon = view.findViewById(R.id.btn_fragment_main_Coupon);
        btnDiaChi = view.findViewById(R.id.btn_fragment_main_DiaChi);
        btnTichDiem = view.findViewById(R.id.btn_fragment_main_TichDiem);

        imgbtAva = view.findViewById(R.id.imgAva);

        imgbtAva.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mainActivity, LoginActivity.class);
                startActivity(intent);
                mainActivity.finish();
            }
        });

        btnTichDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TichDiem.class);
                startActivity(intent);
            }
        });

        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.navigationView.setCheckedItem(R.id.itemHomeMenu);
                Fragment fragment = new MenuMonFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).show(fragment).commit();
            }
        });

        btnDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MapsFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).show(fragment).commit();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            this.mainActivity = (MainActivity)context;
        }
    }
}
