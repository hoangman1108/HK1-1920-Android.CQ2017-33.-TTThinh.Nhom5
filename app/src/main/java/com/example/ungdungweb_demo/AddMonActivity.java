package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class AddMonActivity extends AppCompatActivity {

    int REQUEST_CODE_IMAGE = 1;
    int index;
//    String key="LtdPVepUCWckzizg8S9";
//    String keyMon ="";
    EditText Name, gia;
    ImageView anh;
    Button them;
    private String urlSSS = null;
    public static final int PICK_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mon);

        Name = findViewById(R.id.edt_dialog_themmon_ten);
        gia = findViewById(R.id.edt_dialog_themmon_gia);
        them = findViewById(R.id.btn_add_mon_them);
        anh  = findViewById(R.id.imgview_dialog_themmon);
//        Calendar calendar = Calendar.getInstance();
//        StorageReference mountainsRef =MainActivity.storageRef.child("image"+calendar.getTimeInMillis()+".png");

        anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE_IMAGE);*/

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });



        final MonNuoc monN = QuanLy.monNuocArrayList.get(QuanLy.monNuocArrayList.size()-1);
        if(monN.getTenMon2() == null){
            index = 1;
        }else{
            index = 0;
        }



        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final StorageReference mountainsRef =MainActivity.storageRef.child("image"+calendar.getTimeInMillis()+".png");

                anh.setDrawingCacheEnabled(true);
                anh.buildDrawingCache();

                Bitmap bitmap = ((BitmapDrawable) anh.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
//                uploadTask.addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        Toast.makeText(AddMonActivity.this, "Lỗi!!", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                        Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
//                        while (!urlTask.isSuccessful());
//                        Uri downloadUrl = urlTask.getResult();
//                        urlSSS = downloadUrl.toString();
//                        Log.d("ABCDAS",urlSSS);
//                    }
//                });

                if(index == 0){
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(AddMonActivity.this, "Lỗi!!", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!urlTask.isSuccessful());
                            Uri downloadUrl = urlTask.getResult();
                            urlSSS = downloadUrl.toString();
                            Log.d("ABCDAS",urlSSS);
                            MonNuoc monNuoc = new MonNuoc(gia.getText().toString(),Name.getText().toString(),urlSSS);
                            QuanLy.mData.child("MonNuoc").push().setValue(monNuoc);
                            index =1;
                            QuanLy.monNuocArrayList.add(monNuoc);
                            finish();
                        }
                    });


                }else if(index == 1) {


                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(AddMonActivity.this, "Lỗi!!", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            MonNuoc mon = QuanLy.monNuocArrayList.get(QuanLy.monNuocArrayList.size()-1);
                            Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!urlTask.isSuccessful());
                            Uri downloadUrl = urlTask.getResult();
                            urlSSS = downloadUrl.toString();
                            Log.d("ABCDAS",urlSSS);
                            index =0;
                            MonNuoc monNuoc = new MonNuoc(mon.getGia1(),gia.getText().toString(),mon.getTenMon1(),Name.getText().toString(),mon.getHinh1(),urlSSS);
                            QuanLy.mData.child("MonNuoc").child(MenuActivity.arrIdMon.get(MenuActivity.arrIdMon.size()-1)).setValue(monNuoc);
//                            QuanLy.monNuocArrayList.get(QuanLy.monNuocArrayList.size()-1).setGia2(monNuoc.getGia2());
//                            QuanLy.monNuocArrayList.get(QuanLy.monNuocArrayList.size()-1).setTenMon2(monNuoc.getTenMon2());
//                            QuanLy.monNuocArrayList.get(QuanLy.monNuocArrayList.size()-1).setHinh2(monNuoc.getHinh2());
                            QuanLy.monNuocArrayList.remove(QuanLy.monNuocArrayList.size()-1);
                            MenuActivity.adapter.notifyDataSetChanged();
                            QuanLy.monNuocArrayList.add(monNuoc);
                            MenuActivity.adapter.notifyDataSetChanged();
                            finish();
                        }
                    });


                }

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));


                anh.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
