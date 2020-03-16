package com.travel.dulichviet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview,recyclerview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview1);
        recyclerview2 = findViewById(R.id.recyclerview2);

        // tạo mảng địa danh phổ biến
            int[] Logo_DiadanhPB = {R.drawable.nhatrang,R.drawable.sapa, R.drawable.hoian,R.drawable.image003,R.drawable.banner,R.drawable.halng};
            String [] Ten_DiadanhPB = {" Nha Trang","SaPa","Hội An","Hang Phượng Hoàng","Tràng An","Hạ Long"};

        // cap phat va add vao mang phổ biến
        List<DiaDanh_Modles> diaDanh_modles = new ArrayList<>();
            for (int i = 0 ; i < Logo_DiadanhPB.length ; i ++)
            {
                DiaDanh_Modles modles = new DiaDanh_Modles(Logo_DiadanhPB[i],Ten_DiadanhPB[i]);
                diaDanh_modles.add(modles);
            }
            // thiết kế list theo kiều ngang

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(new RecyclerDataAdapter(this, (ArrayList<DiaDanh_Modles>) diaDanh_modles));


        // tạo mảng địa danh nổi tiếng
        int[] Logo_DiadanhNT = {R.drawable.captreo,R.drawable.daophuquoc,R.drawable.nhahatlonhn,R.drawable.trangan,R.drawable.hue};
        String [] Ten_DiadanhNT = {"Cáp treo Vinpearl","Đảo Phú Quốc","Nhà Hát lớn HN","Tràng An","Kinh Đô Huế"};

// cấp phát và add vào mảng nổi tiếng
        List<DiaDanh_Modles> datas = new ArrayList<>();
        for (int j = 0 ; j < Logo_DiadanhNT.length ; j++)
        {
            DiaDanh_Modles modles1 = new DiaDanh_Modles(Logo_DiadanhNT[j],Ten_DiadanhNT[j] );
            datas.add(modles1);
        }
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview2.setLayoutManager(layoutManager1);
        recyclerview2.setHasFixedSize(true);
        recyclerview2.setAdapter(new RecyclerDataAdapter(this,(ArrayList<DiaDanh_Modles>) datas));
    }

}
