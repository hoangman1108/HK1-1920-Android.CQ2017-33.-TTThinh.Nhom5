package com.example.ungdungweb_demo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RequestAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<RequestXacnhan> list;

    public RequestAdapter(Context context, int layout, List<RequestXacnhan> list) {
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
        TextView tvRequest;
        TextView tvTime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.tvRequest = convertView.findViewById(R.id.tv_dia_xacnhan);
            viewHolder.tvTime = convertView.findViewById(R.id.tv_dia_request_time);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        RequestXacnhan requestXacnhan = list.get(position);
        viewHolder.tvRequest.setText(requestXacnhan.request);
        viewHolder.tvTime.setText(requestXacnhan.time);


        return convertView;
    }
}
