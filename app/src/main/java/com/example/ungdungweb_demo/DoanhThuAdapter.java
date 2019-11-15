package com.example.ungdungweb_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DoanhThuAdapter extends BaseAdapter {
    Context context;
    List<DoanhThu> list;
    int layout;

    public DoanhThuAdapter(Context context, int layout,List<DoanhThu> list) {
        this.context = context;
        this.list = list;
        this.layout = layout;
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
        TextView Time, Sdt,Money;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.Time = convertView.findViewById(R.id.tv_dia_pos_time);
            viewHolder.Sdt = convertView.findViewById(R.id.tv_dia_pos_doanhthu_sdt);
            viewHolder.Money = convertView.findViewById(R.id.tv_dia_pos_doanhthu_giabill);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        DoanhThu doanhThu = list.get(position);

        viewHolder.Time.setText(doanhThu.Time);
        viewHolder.Sdt.setText(doanhThu.sdt);
        viewHolder.Money.setText(doanhThu.Tien);
        return convertView;
    }
}
