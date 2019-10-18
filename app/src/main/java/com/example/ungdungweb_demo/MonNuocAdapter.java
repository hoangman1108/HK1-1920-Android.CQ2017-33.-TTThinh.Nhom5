package com.example.ungdungweb_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonNuocAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<MonNuoc> list;

    public MonNuocAdapter(Context context, int layout, List<MonNuoc> list) {
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
        ImageView imageView;
        TextView tvTenMon1;
        Button btnGia1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.imageView);
            viewHolder.btnGia1 = (Button)convertView.findViewById(R.id.btnThemMon1);
//            viewHolder.btnGia2 = (Button)convertView.findViewById(R.id.btnThemMon2);
            viewHolder.tvTenMon1 = (TextView)convertView.findViewById(R.id.tvTenMon1);
//            viewHolder.tvTenMon2 = (TextView)convertView.findViewById(R.id.tvTenMon2);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MonNuoc monNuoc = list.get(position);
        viewHolder.imageView.setImageResource(R.drawable.ava);
        viewHolder.btnGia1.setText(monNuoc.getGia()+" đ");
        viewHolder.tvTenMon1.setText(monNuoc.getTenMon());

        return convertView;
    }
}
