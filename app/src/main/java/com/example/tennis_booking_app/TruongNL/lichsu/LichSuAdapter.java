package com.example.tennis_booking_app.TruongNL.lichsu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tennis_booking_app.R;

import java.util.List;

public class LichSuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<History> historyList;

    public LichSuAdapter(Context context, int layout, List<History> historyList) {
        this.context = context;
        this.layout = layout;
        this.historyList = historyList;
    }

    @Override
    public int getCount() {
        return historyList.size();
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

        ImageView imgLogo=(ImageView) convertView.findViewById(R.id.imgLogo);
        TextView txtTenHis=(TextView) convertView.findViewById(R.id.txtTenHis);
        TextView txtCaHis=(TextView) convertView.findViewById(R.id.txtCaHis);
        TextView txtNgayGio=(TextView) convertView.findViewById(R.id.txtNgayGio);
        TextView txtTienHis=(TextView) convertView.findViewById(R.id.txtTienHis);

        History history=historyList.get(position);

        txtTenHis.setText(history.getTen());
        txtCaHis.setText(history.getCa());
        txtNgayGio.setText(history.getNgaygio());
        txtTienHis.setText(history.getTien());
        imgLogo.setImageResource(history.getAnh());

        return convertView;
    }
}
