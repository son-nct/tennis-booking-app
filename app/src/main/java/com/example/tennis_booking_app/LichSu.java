package com.example.tennis_booking_app;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LichSu extends AppCompatActivity {
    ListView lvHis;
    LichSuAdapter adapter;
    ArrayList<History> arrHis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su);
        lvHis=(ListView) findViewById(R.id.lvLichsu);
        arrHis=new ArrayList<>();
        arrHis.add(new History(R.drawable.tennis,"Thủ Đức Tennis","Slot 7: 17:45-19:15"," 2 Apr 2022, 8:34","200,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Cộng Hòa Tennis","Slot 2: 8:45-10:15","  4 Apr 2022, 10:00","200,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Thủ Thiêm","Slot 7: 17:00 - 18:30"," 2 Apr 2022, 8:34","200,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Thủ Đức Tennis","Slot 7: 17:00 - 18:30"," 2 Apr 2022, 8:34","200,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Thủ Đức Tennis","Slot 7: 17:00 - 18:30"," 2 Apr 2022, 8:34","200,000vnd"));
        arrHis.add(new History(R.drawable.tennis,"Thủ Đức Tennis","Slot 7: 17:00 - 18:30"," 2 Apr 2022, 8:34","200,000vnd"));

        adapter=new LichSuAdapter(this,R.layout.list_history,arrHis);
        lvHis.setAdapter(adapter);
    }
}