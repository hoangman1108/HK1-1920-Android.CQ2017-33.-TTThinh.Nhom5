package com.example.ungdungweb_demo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class XacNhanAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<GioHang> list;

    public XacNhanAdapter(Context context, int layout, List<GioHang> list) {
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

    public class ViewHoler{
        TextView ten;
        TextView gia;
        TextView soluong;
        ImageView imgHinh;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHolder;
        if (convertView == null){
            viewHolder = new ViewHoler();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.ten = (TextView)convertView.findViewById(R.id.tv_quanly_don_hang_tenmon);
            viewHolder.gia = (TextView)convertView.findViewById(R.id.tv_quanly_don_hang_giamon);
            viewHolder.soluong =(TextView)convertView.findViewById(R.id.tv_quanly_don_hang_soluong);
            viewHolder.imgHinh = convertView.findViewById(R.id.imgview_quanly_don_hang_avata);
            convertView.setTag(viewHolder);
        }
        else{
        viewHolder = (ViewHoler) convertView.getTag();
        }
        GioHang gioHang = list.get(position);
        viewHolder.ten.setText(gioHang.getTenmon());
        viewHolder.gia.setText(gioHang.getGia());
        viewHolder.soluong.setText(gioHang.getSoluong()+"");
        Picasso.get().load(list.get(position).getHinh()).into(viewHolder.imgHinh);


        return convertView;
    }

}
