package com.example.ungdungweb_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnClick;
    private Button btnClickSignup;
    private EditText account, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        MainActivity.userInforArrayList.add(new UserInfor("nguoikhung@gmail.com","0356341653","tototo123","Nguyễn Hoàng Mẫn","11/08/1980","Female"));
//        MainActivity.userInforArrayList.add(new UserInfor("hello@gmail.com","0356981653","tototo123","Nguyễn Văn văn","1/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("alen@gmail.com","03569345653","tototo123","Cao Văn Lầu","11/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("pro@gmail.com","0356933553","tototo123","Nguyễn Văn B","12/1/1999","Female"));
//        MainActivity.userInforArrayList.add(new UserInfor("vip@gmail.com","0356553653","tototo123","Nguyễn Văn C","15/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("vippro123@gmail.com","0356981653","tototo123","Nguyễn Thị D","1/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("baophatnguyen99@gmail.com","0355555553","tototo123","Nguyễn Hữu Cảnh","1/1/1999","Male"));
//        MainActivity.userInforArrayList.add(new UserInfor("a","0355555553","b","Nguyễn Hữu Cảnh","1/1/1999","Male"));
//


        btnClick = findViewById(R.id.btnLogin);
        btnClick.setOnClickListener(this);

        btnClickSignup = findViewById(R.id.btnSignup);
        btnClickSignup.setOnClickListener(this);
    }

    public void onClick (View v)
    {
        if (v == btnClick){
            account = findViewById(R.id.edtAccount);
            pass = findViewById(R.id.edtPass);

            if (checkLogin(account.getText().toString(),pass.getText().toString()))
            {
                Toast.makeText(this  , "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            else Toast.makeText(this  , "Vui lòng kiểm tra lại tài khoản", Toast.LENGTH_LONG).show();
        }

        else if (v == btnClickSignup){
            Intent intent = new Intent(this,SignupActivity.class);
            startActivity(intent);
        }
    }

    public boolean checkLogin(String account, String pass)
    {
        for (int i = 0; i <  MainActivity.userInforArrayList.size(); i++)
        {
            if (account.equals( MainActivity.userInforArrayList.get(i).getEmail()) || account.equals( MainActivity.userInforArrayList.get(i).getPhone()))
            {
                if (pass.equals( MainActivity.userInforArrayList.get(i).getPassword())) {
                    MainActivity.index = i;
                    return true;
                }
            }
        }
        return false;
    }

}
