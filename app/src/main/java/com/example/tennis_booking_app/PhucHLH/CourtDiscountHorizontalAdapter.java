package com.example.tennis_booking_app.PhucHLH;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tennis_booking_app.DetailsPromotion;
import com.example.tennis_booking_app.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.io.Serializable;
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
        holder.txtDiscountText.setText(courtDiscount.getDiscountText());

        holder.rcvPromoCourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_promo);
                dialog.setCanceledOnTouchOutside(true);

                TextView txtPromoTitle = dialog.findViewById(R.id.txtPromoTitle);
                TextView txtShortDiscount = dialog.findViewById(R.id.txtShortDiscount);
                TextView txtDiscountDescription = dialog.findViewById(R.id.txtDiscountDescription);

                txtPromoTitle.setText(courtDiscount.getCourtName());
                txtShortDiscount.setText(courtDiscount.getDiscountText());
                txtDiscountDescription.setText(courtDiscount.getDiscountDescription());
                dialog.show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return arrCourtDiscount.size();
    }


    public class MyDiscountHorizontalViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtDiscountText;
        LinearLayout rcvPromoCourt;

        public MyDiscountHorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinh = itemView.findViewById(R.id.imgCourtPromoHorizontal);
            txtDiscountText = itemView.findViewById(R.id.txtDiscount);
            txtTen = itemView.findViewById(R.id.txtCourtNameHorizontalPromo);
            rcvPromoCourt = itemView.findViewById(R.id.rcvPromoCourt);
        }
    }
}
