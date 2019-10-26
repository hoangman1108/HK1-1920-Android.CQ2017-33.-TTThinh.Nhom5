package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnClick;
    private Button btnClickSignup;
    private EditText account, pass;

    ArrayList<UserInfor> userInforArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        userInforArrayList = new ArrayList<>();

        userInforArrayList.add(new UserInfor("nguoikhung@gmail.com","0356341653","tototo123"));
        userInforArrayList.add(new UserInfor("hello@gmail.com","0356981653","tototo123"));
        userInforArrayList.add(new UserInfor("alen@gmail.com","03569345653","tototo123"));
        userInforArrayList.add(new UserInfor("pro@gmail.com","0356933553","tototo123"));
        userInforArrayList.add(new UserInfor("vip@gmail.com","0356553653","tototo123"));
        userInforArrayList.add(new UserInfor("vippro123@gmail.com","0356981653","tototo123"));
        userInforArrayList.add(new UserInfor("baophatnguyen99@gmail.com","0355555553","tototo123"));


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
        for (int i = 0; i < userInforArrayList.size(); i++)
        {
            if (account.equals(userInforArrayList.get(i).getEmail()) || account.equals(userInforArrayList.get(i).getPhone()))
            {
                if (pass.equals(userInforArrayList.get(i).getPassword()));
                return true;
            }
        }
        return false;
    }

}
