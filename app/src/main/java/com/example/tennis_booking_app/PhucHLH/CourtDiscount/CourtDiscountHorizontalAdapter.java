package com.example.tennis_booking_app.PhucHLH.CourtDiscount;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tennis_booking_app.R;

import java.util.List;

public class CourtDiscountHorizontalAdapter extends RecyclerView.Adapter<CourtDiscountHorizontalAdapter.MyDiscountHorizontalViewHolder> {

    private List<CourtDiscount> arrCourtDiscount;
    Context context;

    public CourtDiscountHorizontalAdapter(List<CourtDiscount> arrCourtDiscount, Context context) {
        this.arrCourtDiscount = arrCourtDiscount;
        this.context = context;
    }

    @NonNull
    @Override
    public MyDiscountHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.horizontal_promotion_view, parent, false);
        MyDiscountHorizontalViewHolder myDiscountHorizontalViewHolder = new MyDiscountHorizontalViewHolder(view);
        return myDiscountHorizontalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyDiscountHorizontalViewHolder holder, int position) {
        CourtDiscount courtDiscount = arrCourtDiscount.get(position);
        holder.imgHinh.setImageResource(courtDiscount.getCourtImage());
        holder.txtTen.setText(courtDiscount.getCourtName());
        holder.txtGiaSauGiam.setText(courtDiscount.getPriceAfter());
        holder.txtGiaTruocGiam.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.txtGiaTruocGiam.setText(courtDiscount.getPriceBefore());
    }

    @Override
    public int getItemCount() {
        return arrCourtDiscount.size();
    }


    public class MyDiscountHorizontalViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtGiaTruocGiam, txtGiaSauGiam;

        public MyDiscountHorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinh = itemView.findViewById(R.id.imgCourtPromoHorizontal);
            txtTen = itemView.findViewById(R.id.txtCourtNameHorizontalPromo);
            txtGiaTruocGiam = itemView.findViewById(R.id.txtPriceBeforeDiscount);
            txtGiaSauGiam = itemView.findViewById(R.id.txtPriceAfterDiscount);
        }
    }
}
