package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    EditText oldpass, newpass, newpassagain;
    Button doi, huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        oldpass = findViewById(R.id.edt_doimk_pass);
        newpass = findViewById(R.id.edt_doimk_passnew);
        newpassagain = findViewById(R.id.edt_doimk_passmewagain);
        doi = findViewById(R.id.btn_doimatkhau_doi);
        huy = findViewById(R.id.btn_doimatkhau_huy);


        doi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oldpass.getText().toString().equals(MainActivity.userInforArrayList.get(MainActivity.index).getPassword())){
                    if(newpass.getText().toString().equals(newpassagain.getText().toString())){
                        MainActivity.userInforArrayList.get(MainActivity.index).password = newpass.getText().toString();
                        MainActivity.mData.child("UserInfor").child(MainActivity.keyUser.get(MainActivity.index)).setValue(MainActivity.userInforArrayList.get(MainActivity.index));
                        Toast.makeText(ChangePassword.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(ChangePassword.this, "Mật khẩu mới không khớp", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ChangePassword.this, "Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });

        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
