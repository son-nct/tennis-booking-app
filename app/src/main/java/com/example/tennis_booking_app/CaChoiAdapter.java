package com.example.tennis_booking_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.tennis_booking_app.Models.Slot.SlotValue;
import com.example.tennis_booking_app.ViewModels.Slot.SlotRespone;

import java.io.Serializable;
import java.util.List;

public class CaChoiAdapter extends BaseAdapter {

    private Context context;
    SharedPreferences sharedPreferences;
    private List<SlotRespone> slotList;

    public CaChoiAdapter(Context context, List<SlotRespone> slotList, SharedPreferences sharedPreferences) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.slotList = slotList;
    }

    @Override
    public int getCount() {
        return slotList.size();
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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_ca_choi, null);

        TextView txtSlot = (TextView) convertView.findViewById(R.id.btSLot);
        TextView txtThoiluong = (TextView) convertView.findViewById(R.id.txtThoi);
        TextView txtGia = (TextView) convertView.findViewById(R.id.txtGia);
        CheckBox cbCachoi = (CheckBox) convertView.findViewById(R.id.cbCaChoi);
        cbCachoi.setFocusable(false);


        SlotRespone slotValue=slotList.get(position);
        txtSlot.setText(slotValue.getNo());
        txtThoiluong.setText(slotValue.getStartTime());
        txtGia.setText(slotValue.getPrice());

        System.out.println(txtSlot.getText().toString()+" dm may thg lon "+txtGia.getText().toString());
        return convertView;

       /* SlotValue caChoi=caChoiList.get(position);



        if(caChoi.getStatus() == 2) {

        btCa.setText(caChoi.getNo());
        txtThoiluong.setText(caChoi.getStartTime().toString() + caChoi.getEndTime().toString());
        txtGia.setText(caChoi.getPrice());*/


        /*if(caChoi.getStatus() == 2) {

            btCa.setTextColor(R.drawable.green);
            txtThoiluong.setTextColor(R.drawable.green);
            txtGia.setTextColor(R.drawable.green);
            cbCachoi.setVisibility(View.INVISIBLE);

        }else {
            cbCachoi.setVisibility(View.VISIBLE);
        }

        btCa.setText(caChoi.getSlot());
        txtThoiluong.setText(caChoi.getThoiluong());
        txtGia.setText(caChoi.getPriceByName());*/
    }
}
