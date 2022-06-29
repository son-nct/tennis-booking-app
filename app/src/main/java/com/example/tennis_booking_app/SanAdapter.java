package com.example.tennis_booking_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SanAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<SanTennis> sanTennisList;

    public SanAdapter(Context context, int layout, ArrayList<SanTennis> sanTennisList) {
        this.context = context;
        this.layout = layout;
        this.sanTennisList = sanTennisList;
    }

    @Override
    public int getCount() {
        return sanTennisList.size();
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

        ImageView imgHinh=(ImageView) convertView.findViewById(R.id.imgHinh);
        TextView txtTen=(TextView) convertView.findViewById(R.id.txtTensan);
        TextView txtDientich=(TextView) convertView.findViewById(R.id.txtDientich);
        TextView txtTien=(TextView) convertView.findViewById(R.id.txtTien);
        TextView txtKhoangCach =(TextView) convertView.findViewById(R.id.txtKhoangCach);

        SanTennis san=sanTennisList.get(position);

        imgHinh.setImageResource(san.getHinh());
        txtTen.setText(san.getTen());
        txtDientich.setText(san.getDientich());
        txtTien.setText(san.getTien());
        txtKhoangCach.setText(san.getKhoangCach());

        return convertView;
    }
}
