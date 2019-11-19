package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class QuangCaoActivity extends AppCompatActivity {

    ImageView image1, image2, image3;
    public static final int PICK_IMAGE = 1;
    private String urlSSS = null;

    public static int stt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quang_cao);
        image1 = findViewById(R.id.imgview_quangcao_1);
        image2 = findViewById(R.id.imgview_quangcao_2);
        image3 = findViewById(R.id.imgview_quangcao_3);

        Picasso.get().load(MainActivity.slideshowArrayList.get(0).getUrl()).into(image1);
        Picasso.get().load(MainActivity.slideshowArrayList.get(1).getUrl()).into(image2);
        Picasso.get().load(MainActivity.slideshowArrayList.get(2).getUrl()).into(image3);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stt = 0;
                final Dialog dialog = new Dialog(QuangCaoActivity.this);
                dialog.setContentView(R.layout.dialog_xoa_mon);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(true);
                TextView thongbao = dialog.findViewById(R.id.tv_dialog_xoa_mon);
                Button dongy = dialog.findViewById(R.id.dialog_xoa_mon_delete);
                Button thoat = dialog.findViewById(R.id.dialog_xoa_mon_cancel);

                thongbao.setText("Bạn muốn thay đổi quảng cáo này?");
                dongy.setText("Đồng ý");
                thoat.setText("Không");

                thoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(QuangCaoActivity.this, ChangeSlideShowActivity.class));
                        finish();
                    }
                });
                dialog.show();
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stt = 1;
                final Dialog dialog = new Dialog(QuangCaoActivity.this);
                dialog.setContentView(R.layout.dialog_xoa_mon);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(true);
                TextView thongbao = dialog.findViewById(R.id.tv_dialog_xoa_mon);
                Button dongy = dialog.findViewById(R.id.dialog_xoa_mon_delete);
                Button thoat = dialog.findViewById(R.id.dialog_xoa_mon_cancel);

                thongbao.setText("Bạn muốn thay đổi quảng cáo này?");
                dongy.setText("Đồng ý");
                thoat.setText("Không");

                thoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(QuangCaoActivity.this, ChangeSlideShowActivity.class));
                        finish();
                    }
                });
                dialog.show();
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stt = 2;
                final Dialog dialog = new Dialog(QuangCaoActivity.this);
                dialog.setContentView(R.layout.dialog_xoa_mon);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(true);
                TextView thongbao = dialog.findViewById(R.id.tv_dialog_xoa_mon);
                Button dongy = dialog.findViewById(R.id.dialog_xoa_mon_delete);
                Button thoat = dialog.findViewById(R.id.dialog_xoa_mon_cancel);

                thongbao.setText("Bạn muốn thay đổi quảng cáo này?");
                dongy.setText("Đồng ý");
                thoat.setText("Không");

                thoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(QuangCaoActivity.this, ChangeSlideShowActivity.class));
                        finish();
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuangCaoActivity.this, QuanLy.class));
        finish();
    }
}
