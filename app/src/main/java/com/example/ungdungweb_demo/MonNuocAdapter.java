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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MonNuocAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private List<MonNuoc> list;
    private  int soluong = 1;
    private String giagoc="";

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
                dialog.setContentView(R.layout.dialog_mua);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(true);

                final RadioButton radioButtonVua = dialog.findViewById(R.id.dialog_radio_vua);
                final RadioButton radioButtonLon = dialog.findViewById(R.id.dialog_radio_lon);
                Button btnsub = dialog.findViewById(R.id.dia_btn_mua_sub);
                final Button btnadd=dialog.findViewById(R.id.dia_btn_mua_add);
                final Button btnMua = dialog.findViewById(R.id.dialog_btn_Mua);
                final TextView tvSoluong = dialog.findViewById(R.id.dia_soluong);
                ImageView imageView = dialog.findViewById(R.id.dialog_imgviewCoffee);

                final TextView tvGia = dialog.findViewById(R.id.dialog_tvGia);
                final TextView tvTen = dialog.findViewById(R.id.dialog_tvTenmon);

                Picasso.get().load(monNuoc.getHinh1()).into(imageView);
                tvTen.setText(viewHolder.tvTenMon1.getText());
                tvGia.setText(viewHolder.btnGia1.getText());
                btnMua.setText(viewHolder.btnGia1.getText());

                String temp = (String)tvGia.getText();
                int i = 0;
                while (temp.charAt(i) != '.'){
                    giagoc += temp.charAt(i);
                    i++;
                }

                radioButtonVua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        int k = Integer.parseInt(giagoc)+5;
                        btnMua.setText(k*soluong+".000 đ");
                    }
                });

                radioButtonLon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        btnMua.setText(Integer.parseInt(giagoc)*soluong+".000 đ");
                    }
                });

                btnMua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.gioHangArrayList.add(new GioHang(tvTen.getText().toString(),btnMua.getText().toString(),soluong,monNuoc.getHinh1()));
                        dialog.dismiss();
                    }
                });

                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soluong +=1;
                        int k =0;
                        if(radioButtonLon.isChecked()){
                            k=5;
                        }
                        tvSoluong.setText(soluong+"");
                        btnMua.setText(soluong*(k+Integer.parseInt(giagoc)) +".000 đ");
                    }
                });

                btnsub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(soluong>1)
                        {
                            soluong-=1;
                            int k =0;
                            if(radioButtonLon.isChecked()){
                                k=5;
                            }
                            tvSoluong.setText(soluong+"");
                            btnMua.setText(soluong*(k+Integer.parseInt(giagoc)) +".000 đ");
                        }
                        else   {
                            int k =0;
                            if(radioButtonLon.isChecked()){
                                k=5;
                            }
                            tvSoluong.setText(soluong+"");
                            btnMua.setText(soluong*(k+Integer.parseInt(giagoc)) +".000 đ");
                        }

                    }
                });

                dialog.show();

            }
        });

        if(!viewHolder.tvTenMon2.getText().toString().isEmpty())
        {
            viewHolder.btnGia2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soluong = 1;
                    giagoc = "";
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dialog_mua);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setCanceledOnTouchOutside(true);

                    final RadioButton radioButtonVua = dialog.findViewById(R.id.dialog_radio_vua);
                    final RadioButton radioButtonLon = dialog.findViewById(R.id.dialog_radio_lon);
                    Button btnsub = dialog.findViewById(R.id.dia_btn_mua_sub);
                    final Button btnadd=dialog.findViewById(R.id.dia_btn_mua_add);
                    final Button btnMua = dialog.findViewById(R.id.dialog_btn_Mua);
                    final TextView tvSoluong = dialog.findViewById(R.id.dia_soluong);
                    ImageView imageView = dialog.findViewById(R.id.dialog_imgviewCoffee);


                    final TextView tvGia = dialog.findViewById(R.id.dialog_tvGia);
                    final TextView tvTen = dialog.findViewById(R.id.dialog_tvTenmon);
                    Picasso.get().load(monNuoc.getHinh1()).into(imageView);
                    tvTen.setText(viewHolder.tvTenMon2.getText());
                    tvGia.setText(viewHolder.btnGia2.getText());
                    btnMua.setText(viewHolder.btnGia2.getText());

                    String temp = (String)tvGia.getText();
                    int i = 0;
                    while (temp.charAt(i) != '.'){
                        giagoc += temp.charAt(i);
                        i++;
                    }

                    radioButtonVua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            int k = Integer.parseInt(giagoc)+5;
                            btnMua.setText(k*soluong+".000 đ");
                        }
                    });

                    radioButtonLon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            btnMua.setText(Integer.parseInt(giagoc)*soluong+".000 đ");
                        }
                    });

                    btnMua.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainActivity.gioHangArrayList.add(new GioHang(tvTen.getText().toString(),btnMua.getText().toString(),soluong,monNuoc.getHinh2()));
                            dialog.dismiss();
                        }
                    });

                    btnadd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            soluong +=1;
                            int k =0;
                            if(radioButtonLon.isChecked()){
                                k=5;
                            }
                            tvSoluong.setText(soluong+"");
                            btnMua.setText(soluong*(k+Integer.parseInt(giagoc)) +".000 đ");
                        }
                    });

                    btnsub.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(soluong>1)
                            {
                                soluong-=1;
                            }
                            int k =0;
                            if(radioButtonVua.isChecked()){
                                k=5;
                            }
                            tvSoluong.setText(soluong+"");
                            btnMua.setText(soluong*(k+Integer.parseInt(giagoc)) +".000 đ");
                        }
                    });

                    dialog.show();
                }
            });
        }else {
            viewHolder.btnGia2.setBackgroundColor(Color.TRANSPARENT);
        }

        return convertView;
    }
}
