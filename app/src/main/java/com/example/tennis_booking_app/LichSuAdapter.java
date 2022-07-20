package com.example.tennis_booking_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tennis_booking_app.Models.Booking.BookingDetail;
import com.example.tennis_booking_app.Models.Booking.BookingValue;
import com.example.tennis_booking_app.Models.Booking.Payment;
import com.example.tennis_booking_app.Models.Booking.PaymentDetail;
import com.example.tennis_booking_app.Models.CourtValue;
import com.example.tennis_booking_app.Models.Slot.SlotValue;

import java.util.List;

public class LichSuAdapter extends BaseAdapter {
    Context context;
    private SharedPreferences sharedPreferences;
    private List<BookingValue> bookingList;

    public LichSuAdapter(Context context,SharedPreferences sharedPreferences, List<BookingValue> bookingList) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.bookingList = bookingList;
    }

    @Override
    public int getCount() {
        return bookingList.size();
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
        convertView=inflater.inflate(R.layout.list_history,null);

        ImageView imgLogo=(ImageView) convertView.findViewById(R.id.imgLogo);
        TextView txtTenHis=(TextView) convertView.findViewById(R.id.txtTenHis);
        TextView txtCaHis=(TextView) convertView.findViewById(R.id.txtCaHis);
        TextView txtNgayGio=(TextView) convertView.findViewById(R.id.txtNgayGio);
        TextView txtTienHis=(TextView) convertView.findViewById(R.id.txtTienHis);

        BookingValue bookingValue=bookingList.get(position);

      /*  txtTenHis.setText(bookingValue.getId());
        txtCaHis.setText(bookingValue.getBookingDetail().get(position).getSlotId());
        txtTienHis.setText(bookingValue.getTotalPrice());*/

        return convertView;

        /*BookingValue booking=bookingList.get(position);
        CourtValue court=new CourtValue(booking.getBookingDetail().get(position).getCourtId());
        SlotValue slot=new SlotValue(booking.getBookingDetail().get(position).getSlotId());

        txtTenHis.setText(court.getName());
        txtCaHis.setText(slot.getStartTime().getHours() + slot.getEndTime().getHours());*/

        /*txtTenHis.setText(booking.getBookingDetail().get(position).getSlotId());

        txtCaHis.setText(booking.getBooking().getSlotId());
        txtNgayGio.setText(booking.get);
        txtTienHis.setText(booking.getTotalPrice());
        mgLogo.setImageResource(history.getAnh());*/
    }
}
