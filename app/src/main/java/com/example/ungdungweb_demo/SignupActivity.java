package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText email, phone, pass;
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
            email = findViewById(R.id.edtEmail);
            pass = findViewById(R.id.edtPass);
            phone = findViewById(R.id.edtPhone);

            DatabaseHelper db = DatabaseHelper.getInstance(this);


            db.insertAccount(new UserInfor(email.getText().toString(),phone.getText().toString(),pass.getText().toString()));

            int test1 = db.getTotalUserInfor();

            String test2 = db.getAllUserInfor().get(0).getEmail();


            Toast.makeText(this,"đăng kí thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
