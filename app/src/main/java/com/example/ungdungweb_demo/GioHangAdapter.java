package com.example.ungdungweb_demo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        Button add, sub;
        ImageView imgHinh;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.ten = (TextView)convertView.findViewById(R.id.tv_don_hang_tenmon);
            viewHolder.gia = (TextView)convertView.findViewById(R.id.tv_don_hang_giamon);
            viewHolder.soluong =(TextView)convertView.findViewById(R.id.tv_don_hang_soluong);
            viewHolder.add = convertView.findViewById(R.id.btn_add_gio_hang);
            viewHolder.sub = convertView.findViewById(R.id.btn_sub_gio_hang);
            viewHolder.imgHinh = convertView.findViewById(R.id.imgview_don_hang_avata);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final GioHang gioHang = list.get(position);

        viewHolder.ten.setText(gioHang.getTenmon());
        viewHolder.gia.setText(gioHang.getGia());
        viewHolder.soluong.setText(gioHang.getSoluong()+"");
        Picasso.get().load(list.get(position).getHinh()).into(viewHolder.imgHinh);


        viewHolder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gioHang.getSoluong() == 1){
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dialog_xoa_mon);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setCanceledOnTouchOutside(true);

                    Button btnDelete = dialog.findViewById(R.id.dialog_xoa_mon_delete);
                    Button btnCancel = dialog.findViewById(R.id.dialog_xoa_mon_cancel);

                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    btnDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainActivity.gioHangArrayList.remove(position);
                            GioHangFragment.adaptergiohang.notifyDataSetChanged();
                            GioHangFragment.tvTongTien.setText(GioHangFragment.TongTien()+".000 đ");
                            GioHangFragment.btnTongTien.setText(GioHangFragment.TongTien()+".000 đ");
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
                else{
                    gioHang.setSoluong(gioHang.getSoluong()-1);
                    list.get(position).setSoluong(gioHang.getSoluong());
                    viewHolder.soluong.setText(gioHang.getSoluong()+"");

                    int gia = Gia(gioHang.getGia());
                    gioHang.setGia(gia*gioHang.getSoluong()/(gioHang.getSoluong()+1) +"");
                    viewHolder.gia.setText(gioHang.getGia()+".000 đ");
                    list.get(position).setGia(gioHang.getGia()+".000 đ");
                    GioHangFragment.tvTongTien.setText(GioHangFragment.TongTien()+".000 đ");
                    GioHangFragment.btnTongTien.setText(GioHangFragment.TongTien()+".000 đ");
                }
            }
        });
        viewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gioHang.setSoluong(gioHang.getSoluong()+1);
                list.get(position).setSoluong(gioHang.getSoluong());
                viewHolder.soluong.setText(gioHang.getSoluong()+"");

                int gia = Gia(gioHang.getGia());
                gioHang.setGia(gia*gioHang.getSoluong()/(gioHang.getSoluong()-1) +"");
                viewHolder.gia.setText(gioHang.getGia()+".000 đ");
                list.get(position).setGia(gioHang.getGia()+".000 đ");
                GioHangFragment.tvTongTien.setText(GioHangFragment.TongTien()+".000 đ");
                GioHangFragment.btnTongTien.setText(GioHangFragment.TongTien()+".000 đ");
            }
        });
        return convertView;
    }


    private int Gia(String str){
        String temp="";
        for(int i = 0;i<str.length();i++){

            if(str.charAt(i)=='.'){
               break;
            }
            temp+=str.charAt(i);
        }
        return Integer.parseInt(temp);
    }
}
