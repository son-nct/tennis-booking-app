package com.example.tennis_booking_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KmAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Promo> promoList;

    public KmAdapter(Context context, int layout, List<Promo> promoList) {
        this.context = context;
        this.layout = layout;
        this.promoList = promoList;
    }

    @Override
    public int getCount() {
        return promoList.size();
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

        TextView txtTenPromo=(TextView) convertView.findViewById(R.id.txtTenPromo);
        TextView txtMotaPromo=(TextView) convertView.findViewById(R.id.txtMotaPromo);
        TextView txtCuthe=(TextView) convertView.findViewById(R.id.txtCuthe);
        ImageView imgPromo=(ImageView) convertView.findViewById(R.id.imgPromo);

        Promo promo=promoList.get(position);

        txtTenPromo.setText(promo.getTen());
        txtMotaPromo.setText(promo.getMota());
        txtCuthe.setText(promo.getCuthe());
        imgPromo.setImageResource(promo.getHinh());

        return convertView;

    }
}
