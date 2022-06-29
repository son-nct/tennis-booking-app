package com.example.tennis_booking_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {
    private List<SanKM> arrKMList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinh;
        TextView txtTenSanPromo, txtDienTichPromo, txtPromoCode, txtGiaPromo;
        RelativeLayout rvSan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinh = itemView.findViewById(R.id.imgHinhPromo);
            txtTenSanPromo = itemView.findViewById(R.id.txtTenSanPromo);
            txtDienTichPromo = itemView.findViewById(R.id.txtDienTichPromo);
            txtPromoCode = itemView.findViewById(R.id.txtCodePromo);
            txtGiaPromo = itemView.findViewById(R.id.txtGiaPromo);
            rvSan = itemView.findViewById(R.id.rvSan);
        }
    }

    public HorizontalAdapter(Context context, List<SanKM> arrKMList) {
        this.arrKMList = arrKMList;
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
        SanKM sanKM = arrKMList.get(position);
        System.out.println("1333333333333333333333333333333333333333321" + arrKMList.get(position).getHinh());
        System.out.println("8888888888888888888888888888888888888888888" + holder);
        System.out.println("999999999999999999999999999999999999999" + holder.imgHinh);
        holder.imgHinh.setImageResource(sanKM.getHinh());
        holder.txtTenSanPromo.setText(sanKM.getTen());
        holder.txtDienTichPromo.setText(sanKM.getDientich());
        holder.txtPromoCode.setText(sanKM.getPromoCode());
        holder.txtGiaPromo.setText(sanKM.getTien());
        holder.rvSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, YardDetail.class);
                intent.putExtra("sandetail", (Serializable) sanKM);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrKMList.size();
    }

}
