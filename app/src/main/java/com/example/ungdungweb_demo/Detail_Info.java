package com.example.ungdungweb_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Detail_Info extends AppCompatActivity {

    Button btn_change;
    TextView txtName,txtEmail,txtPhone,txtBirthday,txtGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__info);

        btn_change=findViewById(R.id.btn_change);
        txtName=findViewById(R.id.detail_name);
        txtEmail=findViewById(R.id.detail_email);
        txtBirthday=findViewById(R.id.detail_birthday);
        txtPhone=findViewById(R.id.detail_phone);
        txtGender=findViewById(R.id.detail_gender);

//        Intent intent=getIntent();
//        Bundle bundle=intent.getBundleExtra("infor");
//
//        txtName.setText(bundle.getString("name"));
//        txtPhone.setText(bundle.getString("phone"));
//        txtEmail.setText(bundle.getString("email"));
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeInformation();
            }
        });



    }



    protected void ChangeInformation(){

        final Dialog dialog=new Dialog(Detail_Info.this);
        dialog.setContentView(R.layout.dialog_change_info);

        Button dialog_btn_cancel=dialog.findViewById(R.id.dialog_btn_cancel);
        Button dialog_btn_change=dialog.findViewById(R.id.dialog_btn_change);
        final EditText dialog_detail_name=dialog.findViewById(R.id.dialog_detail_name);
        final EditText dialog_detail_email=dialog.findViewById(R.id.dialog_detail_email);
        final EditText dialog_detail_birthday=dialog.findViewById(R.id.dialog_detail_birthday);
        final EditText dialog_detail_phone=dialog.findViewById(R.id.dialog_detail_phone);
        final RadioButton radioButton_male=dialog.findViewById(R.id.dialog_rabtn_male);
        final RadioButton radioButton_female=dialog.findViewById(R.id.dialog_rabtn_female);
        dialog_detail_name.setText(txtName.getText());
        dialog_detail_email.setText(txtEmail.getText());
        dialog_detail_birthday.setText(txtBirthday.getText());
        dialog_detail_phone.setText(txtPhone.getText());
        dialog_btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog_btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtName.setText(dialog_detail_name.getText());
                txtBirthday.setText(dialog_detail_birthday.getText());
                txtEmail.setText(dialog_detail_email.getText());
                txtPhone.setText(dialog_detail_phone.getText());

                MainActivity.menu1.findItem(R.id.itemName).setTitle(txtName.getText());
                MainActivity.menu1.findItem(R.id.itemEmail).setTitle(txtEmail.getText());
                MainActivity.menu1.findItem(R.id.itemSdt).setTitle(txtPhone.getText());
                if(radioButton_female.isChecked())
                {
                    txtGender.setText(radioButton_female.getText());
                }
                else
                {
                    txtGender.setText(radioButton_male.getText());
                }
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}

