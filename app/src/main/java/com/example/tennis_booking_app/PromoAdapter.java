package com.example.tennis_booking_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {

    private ArrayList<com.example.copy.PromoClass> proList;

    public PromoAdapter(ArrayList<com.example.copy.PromoClass> proList) {
        this.proList = proList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);

        View view=inflater.inflate(R.layout.list_san_km,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com.example.copy.PromoClass promo=proList.get(position);
        holder.txtPromo.setText(promo.getPromo());
        holder.txtTenSan.setText(promo.getTenSan());
        holder.txtDistant.setText(promo.getKhoangCach());
        holder.txtMaPromo.setText(promo.getMaKM());
        holder.imgHinhSan.setImageResource(promo.getHinh());
        holder.imgStar.setImageResource(promo.getSao());
        holder.imgThe.setImageResource(promo.getThe());

    }

    @Override
    public int getItemCount() {
        return proList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhSan,imgStar,imgThe;
        TextView txtPromo,txtTenSan,txtDistant,txtMaPromo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHinhSan=itemView.findViewById(R.id.imgHinhSan);
            imgStar=itemView.findViewById(R.id.imgStar);
            imgThe=itemView.findViewById(R.id.imgThePro);
            txtPromo=itemView.findViewById(R.id.txtPromo);
            txtTenSan=itemView.findViewById(R.id.txtTenSan);
            txtDistant=itemView.findViewById(R.id.txtDistant);
            txtMaPromo=itemView.findViewById(R.id.txtMaPromo);
        }
    }
}
