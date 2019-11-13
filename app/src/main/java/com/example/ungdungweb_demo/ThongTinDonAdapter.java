package com.example.ungdungweb_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ThongTinDonAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<DonHang> list;

    public ThongTinDonAdapter(Context context, int layout, List<DonHang> list) {
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
        TextView sdtnguoigui;
        TextView tvTime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.sdtnguoigui= convertView.findViewById(R.id.tv_dia_thongtinxacnhan);
            viewHolder.tvTime = convertView.findViewById(R.id.tv_dia_xacnhanguoigui_time);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        DonHang donHang = list.get(position);
        viewHolder.sdtnguoigui.setText("Có đơn hàng từ Sđt: "+donHang.getSdt());
        viewHolder.tvTime.setText(donHang.getTime());

        return convertView;
    }
}
