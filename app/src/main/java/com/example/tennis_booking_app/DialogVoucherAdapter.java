package com.example.tennis_booking_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tennis_booking_app.Models.LoadImage;
import com.example.tennis_booking_app.Models.Voucher;

import java.util.List;

public class DialogVoucherAdapter extends BaseAdapter {
    private Context context;
    List<Voucher> arrVoucher;
    private SharedPreferences sharedPreferences;

    public DialogVoucherAdapter(Context context, List<Voucher> arrVoucher, SharedPreferences sharedPreferences) {
        this.context = context;
        this.arrVoucher = arrVoucher;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public int getCount() {
        return arrVoucher.size();
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
        convertView = inflater.inflate(R.layout.horizontal_promotion_view, null);

        ImageView imgHinhKM = (ImageView) convertView.findViewById(R.id.imgHinhKM);
        TextView txtTenKM = (TextView) convertView.findViewById(R.id.txtTensanKM);
        TextView txtDientichKM = (TextView) convertView.findViewById(R.id.txtDientichKM);
        TextView txtTienKM = (TextView) convertView.findViewById(R.id.txtTienKM);
        LinearLayout loKM = convertView.findViewById(R.id.loKM);
        try {
            Voucher voucher = arrVoucher.get(position);
            txtTenKM.setText(voucher.getName());
            txtTienKM.setText(voucher.getDiscountPrice() + "");

            String imageURL = voucher.getImageUrl();
            LoadImage loadImage = new LoadImage(imgHinhKM);
            loadImage.execute(imageURL);
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertView;
    }
}
