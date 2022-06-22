package com.example.tennis_booking_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SanKmAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<SanKM> sanList;

    public SanKmAdapter(Context context, int layout, ArrayList<SanKM> sanList) {
        this.context = context;
        this.layout = layout;
        this.sanList = sanList;
    }

    @Override
    public int getCount() {
        return sanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout,null);

        ImageView imgHinhKM=(ImageView) convertView.findViewById(R.id.imgHinhKM);
        TextView txtTenKM=(TextView) convertView.findViewById(R.id.txtTensanKM);
        TextView txtDientichKM=(TextView) convertView.findViewById(R.id.txtDientichKM);
        TextView txtTienKM=(TextView) convertView.findViewById(R.id.txtTienKM);

        SanKM sanKM=sanList.get(position);
        imgHinhKM.setImageResource(sanKM.getHinh());
        txtTenKM.setText(sanKM.getTen());
        txtDientichKM.setText(sanKM.getDientich());
        txtTienKM.setText(sanKM.getTien());

        return convertView;
    }
}
