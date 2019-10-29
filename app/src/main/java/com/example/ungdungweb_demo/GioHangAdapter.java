package com.example.ungdungweb_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GioHangAdapter extends BaseAdapter {

    private Context context;
    private int layout;

    public GioHangAdapter(Context context, int layout, List<GioHang> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    private List<GioHang> list;
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
        TextView ten;
        TextView gia;
        TextView soluong;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.ten = (TextView)convertView.findViewById(R.id.tv_don_hang_tenmon);
            viewHolder.gia = (TextView)convertView.findViewById(R.id.tv_don_hang_giamon);
            viewHolder.soluong =(TextView)convertView.findViewById(R.id.tv_don_hang_soluong);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        GioHang gioHang = list.get(position);

        viewHolder.ten.setText(gioHang.getTenMon());
        viewHolder.gia.setText(gioHang.getGia());
        viewHolder.soluong.setText(gioHang.getSoLuong()+"");

        return convertView;
    }
}
