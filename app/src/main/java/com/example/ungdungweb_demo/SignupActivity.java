package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {


    private EditText edtName, edtEmail, edtSdt, edtDate, edtpass;
    private Button btnsignup;
    private RadioButton raMale, raFemale;
    private String gender = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtName = findViewById(R.id.edt_signup_ten);
        edtEmail = findViewById(R.id.edt_signup_email);
        edtDate = findViewById(R.id.edt_signup_date);
        edtSdt = findViewById(R.id.edt_signup_sdt);
        raMale = findViewById(R.id.radio_signup_male);
        raFemale = findViewById(R.id.radio_signup_female);
        btnsignup = findViewById(R.id.btnSignup);

        edtpass = findViewById(R.id.edt_signup_pass);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Check()){
                    if(raFemale.isChecked())
                    {
                        gender = "Female";
                    }
                    else{
                        gender = "Male";
                    }
//                    UserInfor(String email, String phone, String password, String name, String date, String gender)
                    MainActivity.mData.child("UserInfor").push().setValue(new UserInfor(edtEmail.getText().toString(),edtSdt.getText().toString(),edtpass.getText().toString(),edtName.getText().toString(),edtDate.getText().toString(),gender));
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    public boolean Check() {
        if (edtName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tên", Toast.LENGTH_SHORT).show();
            return false;
        }
        String email = edtEmail.getText().toString();

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                String temp = "";

                for (int j = i + 1; j < email.length(); j++) {
                    temp += email.charAt(j);
                }
                if (!temp.equals("gmail.com") && !temp.equals("yahoo.com") && !temp.equals("yahoo.com.vn") && !temp.equals("gmail.com.vn")) {
                    Toast.makeText(this, "Sai email", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            if (email.charAt(i) == ' ') {
                Toast.makeText(this, "Sai email", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        String sdt = edtSdt.getText().toString();
        if(sdt.length() != 10){
            Toast.makeText(this, "Vui lòng nhập số điện thoại hợp lệ", Toast.LENGTH_SHORT).show();
            return false;
        }

        for(int i = 0;i<10;i++){
            if(sdt.charAt(i)<'0' || sdt.charAt(i)>'9'){
                Toast.makeText(this, "Vui lòng nhập số điện thoại hợp lệ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if(edtpass.getText().toString().isEmpty()){
            Toast.makeText(this, "Nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!raMale.isChecked() && !raFemale.isChecked()){
            Toast.makeText(this, "Xác định giới tính", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}


//    @Override
//    public void onClick(View view) {
//        if (view == btnClick)
//        {
//            Toast.makeText(this,"đăng kí thành công",Toast.LENGTH_LONG).show();
////            MainActivity.mData.child("UserInfor").push().setValue(new UserInfor("hoangman772@gmail.com","0967945772","man123","Mẫn Mong Manh","11/08/1998","Male"));
//            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
//            startActivity(intent);
//        }
//    }
