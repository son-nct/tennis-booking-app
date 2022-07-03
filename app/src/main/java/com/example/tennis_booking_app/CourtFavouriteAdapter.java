package com.example.tennis_booking_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourtFavouriteAdapter extends RecyclerView.Adapter<CourtFavouriteAdapter.MyViewHolder> {
    private List<Court> arrCourtFav;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCourt;
        TextView txtCourtName, txtAddress, txtSize, txtPrice;
        LinearLayout courtContainer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCourt = itemView.findViewById(R.id.imgCourtFav);
            txtCourtName = itemView.findViewById(R.id.txtCourtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtSize = itemView.findViewById(R.id.txtSize);
            txtPrice = itemView.findViewById(R.id.txtCourtPrice);
            courtContainer = itemView.findViewById(R.id.courtContainer);
        }
    }

    public CourtFavouriteAdapter(Context context, List<Court> arrCourtFav) {
        this.arrCourtFav = arrCourtFav;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_court_favourite, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Court court_fav = arrCourtFav.get(position);
        holder.imgCourt.setImageResource(court_fav.getImgCourt());
        holder.txtCourtName.setText(court_fav.getName());
        holder.txtAddress.setText(court_fav.getAddress());
        holder.txtSize.setText(court_fav.getWidth()+ "m" + " x " + court_fav.getHeight()+ "m" );
        holder.txtPrice.setText(court_fav.getPrice());


//
//        holder.rvSan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context, YardDetail.class);
//                intent.putExtra("sandetail", (Serializable) sanKM);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return arrCourtFav.size();
    }

}
