package com.example.ungdungweb_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class DeleteMonAdapter extends BaseAdapter {

    Context context;
    List<MonNuoc> list;
    int layout;

    public DeleteMonAdapter(Context context, int layout, List<MonNuoc> list) {
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
        TextView tenmon1,tenmon2;
        Button xoa1,xoa2;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.tenmon1 = (TextView)convertView.findViewById(R.id.tv_dia_xoa_mon_1);
            viewHolder.tenmon2 = (TextView)convertView.findViewById(R.id.tv_dia_xoa_mon_2);
            viewHolder.xoa1 = convertView.findViewById(R.id.btn_dia_xoa_mon_1);
            viewHolder.xoa2 = convertView.findViewById(R.id.btn_dia_xoa_mon_2);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final MonNuoc monNuoc = list.get(position);
        viewHolder.tenmon1.setText(monNuoc.tenmon1);
        viewHolder.tenmon2.setText(monNuoc.tenmon2);

//        if(viewHolder.tenmon2.getText().toString().equals("")){
//            viewHolder.xoa2.setVisibility(convertView.VISIBLE);
//        }

//        if(!monNuoc.getTenMon2().equals(null))
//        {
//            viewHolder.tenmon2.setText(monNuoc.tenmon2);
//        }

        viewHolder.xoa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              if(monNuoc.getTenMon2().equals("")){
//
//
//                 MenuActivity.arrIdMon.remove(position);
//                  viewHolder.xoa2.setVisibility(v.VISIBLE);
//                  notifyDataSetChanged();
//                  list.remove(position);
//                  QuanLy.mData.child("MonNuoc").child(MenuActivity.arrIdMon.get(position)).removeValue();
//              }
//              else{
//                  list.get(position).setHinh1(monNuoc.getHinh2());
//                  list.get(position).setGia1(monNuoc.getGia2());
//                  list.get(position).setTenMon1(monNuoc.tenmon2);
//                  list.get(position).setHinh2(null);
//                  list.get(position).setGia2(null);
//                  list.get(position).setTenMon2(null);
                MonNuoc monNuoc1 = new MonNuoc(list.get(position).gia2,list.get(position).tenmon2,list.get(position).hinh2);
                list.add(position+1,monNuoc1);
                list.remove(position);
//                  list.add(monNuoc1);
                viewHolder.xoa2.setVisibility(v.GONE);
                notifyDataSetChanged();

                QuanLy.mData.child("MonNuoc").child(MenuActivity.arrIdMon.get(position)).setValue(list.get(position));
            }


//            }
        });

        viewHolder.xoa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonNuoc monNuoc1 = new MonNuoc(list.get(position).gia2,list.get(position).tenmon2,list.get(position).hinh2);

                list.get(position).setHinh2(null);
                list.get(position).setGia2(null);
                list.get(position).setTenMon2(null);

                MonNuoc monNuoc2 = new MonNuoc(list.get(position).gia1,list.get(position).tenmon1,list.get(position).hinh1);
                list.add(position+1,monNuoc2);
                list.remove(position);
                notifyDataSetChanged();
                viewHolder.xoa2.setVisibility(v.GONE);

                QuanLy.mData.child("MonNuoc").child(MenuActivity.arrIdMon.get(position)).removeValue();
                QuanLy.mData.child("MonNuoc").push().setValue(list.get(position));
//                QuanLy.mData.child("MonNuoc").child(MenuActivity.arrIdMon.get(position)).setValue(list.get(position));
            }
        });

        return convertView;
    }

}
