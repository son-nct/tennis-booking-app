package com.example.tennis_booking_app.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tennis_booking_app.DetailsPromotion;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.SanKM;
import com.example.tennis_booking_app.YardDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {
    private ArrayList<PagedCourtValue> arrPromoValue;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinh;
        TextView txtTenSanPromo, txtDienTichPromo, txtPromoCode, txtRating, txtKhoangCach;
        LinearLayout rvSan;
        LinearLayout loRatingDistance;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinh = itemView.findViewById(R.id.imgHinhPromo);
            txtTenSanPromo = itemView.findViewById(R.id.txtTenSanPromo);
            txtDienTichPromo = itemView.findViewById(R.id.txtDienTichPromo);
            txtPromoCode = itemView.findViewById(R.id.txtCodePromo);
            txtKhoangCach = itemView.findViewById(R.id.txtKhoangCach);
            txtRating = itemView.findViewById(R.id.txtRating);
            rvSan = itemView.findViewById(R.id.rvSan);
            loRatingDistance = itemView.findViewById(R.id.loRatingDistance);
        }
    }

    public HorizontalAdapter(Context context, ArrayList<PagedCourtValue> arrPromoValue) {
        this.arrPromoValue = arrPromoValue;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_court_horizontal, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PagedCourtValue pagedCourtValue = arrPromoValue.get(position);
        holder.txtTenSanPromo.setText(pagedCourtValue.getName());
        holder.txtRating.setText(String.valueOf(pagedCourtValue.getRatingAverage()));
        holder.txtPromoCode.setText("Ưu đãi đến 50k");
        /*
        holder.imgHinh.setImageResource(sanKM.getHinh());
        holder.txtTenSanPromo.setText(sanKM.getTen());
        holder.txtDienTichPromo.setText(sanKM.getDientich());
        holder.txtPromoCode.setText(sanKM.getPromotionStatus());
        holder.txtGiaPromo.setText(sanKM.getTien());
        holder.txtRating.setText(sanKM.getRating());
        holder.txtKhoangCach.setText(sanKM.getKhoangCach());

        holder.txtGiaPromo.getText().toString().trim();

        holder.rvSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailsPromotion.class);
                intent.putExtra("sandetail", (Serializable) sanKM);
                context.startActivity(intent);
            }
        });
         */

        /*holder.rvSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailsPromotion.class);
                intent.putExtra("sandetail", (Serializable) sanKM);
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return arrPromoValue.size();
    }

}
