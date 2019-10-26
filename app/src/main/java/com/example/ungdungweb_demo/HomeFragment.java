package com.example.ungdungweb_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private ImageButton imgbtnmaps;
    private ImageView imgbtAva;
    public MainActivity mainActivity;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        imgbtnmaps = (ImageButton)view.findViewById(R.id.btnDiaChi);

        imgbtnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(mainActivity, "Maps", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mainActivity, Maps.class);
//                Toast.makeText(mainActivity, "ra nào", Toast.LENGTH_SHORT).show();
//                startActivity(intent);
            }
        });

        imgbtAva = view.findViewById(R.id.imgAva);

        imgbtAva.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mainActivity, LoginActivity.class);
                startActivity(intent);
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
