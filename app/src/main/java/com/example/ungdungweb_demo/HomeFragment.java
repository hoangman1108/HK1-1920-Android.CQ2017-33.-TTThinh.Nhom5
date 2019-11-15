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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {
    ImageButton btnDatHang, btnCoupon, btnTichDiem, btnDiaChi, btnRequest;
    private ImageView imgbtAva;
    public MainActivity mainActivity;
    TextView tvName;
    ViewFlipper viewFlipper;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        btnDatHang = view.findViewById(R.id.btn_fragment_main_DatHang);
        btnCoupon = view.findViewById(R.id.btn_fragment_main_Coupon);
        btnDiaChi = view.findViewById(R.id.btn_fragment_main_DiaChi);
        btnTichDiem = view.findViewById(R.id.btn_fragment_main_TichDiem);
        btnRequest = view.findViewById(R.id.btn_fragment_main_thongbao);
        viewFlipper = view.findViewById(R.id.vflipper_slideshow);
        tvName=view.findViewById(R.id.tv_fragment_main_name);
        int images[] ={R.drawable.trasua1, R.drawable.trasua2, R.drawable.trasua3};

        imgbtAva = view.findViewById(R.id.imgAva);

        if(MainActivity.index!=-1)
        {
            tvName.setText(MainActivity.userInforArrayList.get(MainActivity.index).getName());

        }



//        imgbtAva.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(mainActivity, LoginActivity.class);
//                startActivity(intent);
////                mainActivity.finish();
//                mainActivity.finish();
//            }
//        });

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RequestActivity.class));
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
                MainActivity.navigationView.setCheckedItem(R.id.itemMap);
                Fragment fragment = new MapsFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).show(fragment).commit();
            }
        });

        btnCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Coupon.class);
                startActivity(intent);
            }
        });

        for(int i = 0; i<images.length;i++){
            flipperImages(images[i]);
        }

        //prefer foreach
        for (int image: images){
            flipperImages(image);
        }

        return view;
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        //animation
        viewFlipper.setInAnimation(getContext(),R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(),R.anim.slide_in_right);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            this.mainActivity = (MainActivity)context;
        }
    }
}
