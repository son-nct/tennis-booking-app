package com.example.tennis_booking_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tennis_booking_app.Models.CourtSizeValue;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.ViewModels.Vendor.VendorResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SanKmAdapter extends BaseAdapter {
    private Context context;
    ArrayList<SanKM> arrSanKM;

    public SanKmAdapter(Context context, ArrayList<SanKM> arrSanKM) {
        this.context = context;
        this.arrSanKM = arrSanKM;
    }

    @Override
    public int getCount() {
        return arrSanKM.size();
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
        convertView=inflater.inflate(R.layout.list_san_promo,null);

        ImageView imgHinhKM=(ImageView) convertView.findViewById(R.id.imgHinhKM);
        TextView txtTenKM=(TextView) convertView.findViewById(R.id.txtTensanKM);
        TextView txtDientichKM=(TextView) convertView.findViewById(R.id.txtDientichKM);
        TextView txtTienKM=(TextView) convertView.findViewById(R.id.txtTienKM);

        SanKM sanKM=arrSanKM.get(position);
        imgHinhKM.setImageResource(sanKM.getHinh());
        txtTenKM.setText(sanKM.getTen());
        txtDientichKM.setText(sanKM.getDientich());
        txtTienKM.setText(sanKM.getTien());

//        try {
//            VendorResponse vendorResponse = arrPagedValue.get(position);
//            // get shared prefs
//            sharedPreferences = context.getSharedPreferences("MySharedPref", 0);
//            Gson gson = new Gson();
//            String json = sharedPreferences.getString("LIST_COURT_SIZE", "[]");
//            Type type = new TypeToken<ArrayList<CourtSizeValue>>(){}.getType();
//            List<CourtSizeValue> listCourtSize = gson.fromJson(json, type);
//            for (CourtSizeValue size: listCourtSize) {
//                if(size.getId() == vendorResponse.get()){
//                    txtDientich.setText(size.getWidth() + "m " + "x" + size.getHeight() + "m ");
//                }
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        return convertView;
    }
}
