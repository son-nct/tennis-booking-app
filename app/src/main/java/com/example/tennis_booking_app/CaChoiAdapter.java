package com.example.tennis_booking_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class CaChoiAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<CaChoi> caChoiList;

    public CaChoiAdapter(Context context, int layout, List<CaChoi> caChoiList) {
        this.context = context;
        this.layout = layout;
        this.caChoiList = caChoiList;
    }

    @Override
    public int getCount() {
        return caChoiList.size();
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

        TextView btCa=(TextView) convertView.findViewById(R.id.btSLot);
        TextView txtThoiluong=(TextView) convertView.findViewById(R.id.txtThoi);
        TextView txtGia=(TextView) convertView.findViewById(R.id.txtGia);
        CheckBox cbCachoi=(CheckBox) convertView.findViewById(R.id.cbCaChoi);
        cbCachoi.setFocusable(false);

        CaChoi caChoi=caChoiList.get(position);

       /* if(cbCachoi.isChecked()){
            caChoi.setCb(true);
            Intent intent=new Intent();
            intent.putExtra("cachoi",(Serializable) caChoi);
            context.startActivity(intent);
        }*/
        btCa.setText(caChoi.getSlot());
        txtThoiluong.setText(caChoi.getThoiluong());
        txtGia.setText(caChoi.getPriceByName());

        return convertView;
    }
}
