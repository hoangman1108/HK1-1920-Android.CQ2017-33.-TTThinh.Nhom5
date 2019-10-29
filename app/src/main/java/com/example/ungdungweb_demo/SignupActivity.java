package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {


    private String email, phone, pass;
    private Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnClick = findViewById(R.id.btnSignup);
        btnClick.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == btnClick)
        {
            Toast.makeText(this,"đăng kí thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
