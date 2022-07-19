package com.example.tennis_booking_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VoicherAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    ArrayList<VoidcherTest> arrVoicher;

    public VoicherAdapter(Context context, int layout, ArrayList<VoidcherTest> arrVoicher) {
        this.context = context;
        this.layout = layout;
        this.arrVoicher = arrVoicher;
    }

    @Override
    public int getCount() {
        return arrVoicher.size();
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

        TextView txtTenVoicher,txtMaVoicher;
        txtTenVoicher=convertView.findViewById(R.id.txtTenVoicher);
        txtMaVoicher=convertView.findViewById(R.id.txtMaVoicher);

        VoidcherTest voidcherTest=arrVoicher.get(position);

        txtMaVoicher.setText(voidcherTest.getMaVoi());
        txtTenVoicher.setText(voidcherTest.getTenVoi());

        return null;
    }
}
