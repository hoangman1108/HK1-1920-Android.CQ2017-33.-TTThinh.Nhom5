package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignupActivity extends AppCompatActivity {


    private EditText edtName, edtEmail, edtSdt, edtDate, edtpass;
    private Button btnsignup;
    private RadioButton raMale, raFemale;
    private String gender = "";
    final Calendar myCalendar = Calendar.getInstance();
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


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabel();
            }
        };

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

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignupActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edtDate.setText(sdf.format(myCalendar.getTime()));
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
            for (int k = 0; k <  MainActivity.userInforArrayList.size(); k++)
            {
                if (email.equals( MainActivity.userInforArrayList.get(k).getEmail()) )
                {
                    Toast.makeText(this,"Email đã tồn tại",Toast.LENGTH_LONG).show();
                    return false;
                }
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
        for (int k = 0; k <  MainActivity.userInforArrayList.size(); k++)
        {
            if (sdt.equals( MainActivity.userInforArrayList.get(k).getPhone()) )
            {
                Toast.makeText(this,"Số điện thoại đã tồn tại",Toast.LENGTH_LONG).show();
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
