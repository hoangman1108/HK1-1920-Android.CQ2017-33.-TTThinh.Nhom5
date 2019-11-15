package com.example.ungdungweb_demo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ungdungweb_demo.View.MenuActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SuaMonNuocAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private List<MonNuoc> list;
    private  int soluong = 1;
    private String giagoc="";

    public SuaMonNuocAdapter(Context context, int layout, List<MonNuoc> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public class ViewHolder{
        ImageView imageView1, imageView2;
        TextView tvTenMon1, tvTenMon2;
        Button btnGia1, btnGia2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.imageView1 = (ImageView)convertView.findViewById(R.id.imageView);
            viewHolder.imageView2 = (ImageView)convertView.findViewById(R.id.imageView2);
            viewHolder.btnGia1 = (Button)convertView.findViewById(R.id.btnThemMon1);
            viewHolder.btnGia2 = (Button)convertView.findViewById(R.id.btnThemMon2);
            viewHolder.tvTenMon1 = (TextView)convertView.findViewById(R.id.tvTenMon1);
            viewHolder.tvTenMon2 = (TextView)convertView.findViewById(R.id.tvTenMon2);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final MonNuoc monNuoc = list.get(position);
        Picasso.get().load(monNuoc.getHinh1()).into(viewHolder.imageView1);
        Picasso.get().load(monNuoc.getHinh2()).into(viewHolder.imageView2);

//        viewHolder.imageView1.setImageResource(R.drawable.ava);
//        viewHolder.imageView2.setImageResource(R.drawable.ava);
        viewHolder.tvTenMon1.setText(monNuoc.getTenMon1());
        viewHolder.tvTenMon2.setText(monNuoc.getTenMon2());
        viewHolder.btnGia1.setText(monNuoc.getGia1());
        viewHolder.btnGia2.setText(monNuoc.getGia2());



        viewHolder.btnGia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "Gia "+position+"a", Toast.LENGTH_SHORT).show();
                soluong = 1;
                giagoc = "";
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dia_sua_mon);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(true);

                final EditText edtTen = dialog.findViewById(R.id.edt_dia_sua_mon_tenmon);
                final EditText edtGia = dialog.findViewById(R.id.edt_dia_sua_mon_giamon);
                Button btnSua = dialog.findViewById(R.id.btn_dia_sua_mon_sua);
                Button btnHuy = dialog.findViewById(R.id.btn_dia_sua_mon_huy);
                edtTen.setText(monNuoc.getTenMon1());
                edtGia.setText(monNuoc.getGia1());

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnSua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MonNuoc monNuoc1 = new MonNuoc(edtGia.getText().toString(), monNuoc.getGia2(),edtTen.getText().toString(),monNuoc.getTenMon2(),monNuoc.getHinh1(),monNuoc.getHinh2());
                        Log.d("MANMAN", MenuActivity.arrIdMon.get(position));
                        QuanLy.mData.child("MonNuoc").child(MenuActivity.arrIdMon.get(position)).setValue(monNuoc1);
                        dialog.dismiss();
//                        MenuActivity.Database();
                        list.get(position).setGia1(monNuoc1.getGia1());
                        list.get(position).setTenMon1(monNuoc1.getTenMon1());
                    }
                });
                dialog.show();

            }
        });

        viewHolder.btnGia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "Gia "+position+"a", Toast.LENGTH_SHORT).show();
                soluong = 1;
                giagoc = "";
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dia_sua_mon);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(true);

                final EditText edtTen = dialog.findViewById(R.id.edt_dia_sua_mon_tenmon);
                final EditText edtGia = dialog.findViewById(R.id.edt_dia_sua_mon_giamon);
                Button btnSua = dialog.findViewById(R.id.btn_dia_sua_mon_sua);
                Button btnHuy = dialog.findViewById(R.id.btn_dia_sua_mon_huy);
                edtTen.setText(monNuoc.getTenMon2());
                edtGia.setText(monNuoc.getGia2());

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnSua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MonNuoc monNuoc1 = new MonNuoc(monNuoc.getGia1(), edtGia.getText().toString(),monNuoc.getTenMon1(),edtTen.getText().toString(),monNuoc.getHinh1(),monNuoc.getHinh2());
                        QuanLy.mData.child("MonNuoc").child(MenuActivity.arrIdMon.get(position)).setValue(monNuoc1);
                        dialog.dismiss();
                        list.get(position).setGia2(monNuoc1.getGia2());
                        list.get(position).setTenMon2(monNuoc1.getTenMon2());
//                        MenuActivity.Database();

                    }
                });
                dialog.show();

            }
        });
        return convertView;
    }
}
