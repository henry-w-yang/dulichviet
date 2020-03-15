package com.travel.dulichviet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview1);
        // tạo mảng
            int[] Logo_Diadanh = {R.drawable.sapadwzj,R.drawable.sapa,
                    R.drawable.cave,R.drawable.image003,R.drawable.banner,R.drawable.banner1};
            String [] Ten_Diadanh = {"Cáp treo Vinpearl"," Nha Trang","Đà lạt","Hội An","SaPa","Tràng An"};

            // cap phat va add vao mang
        List<DiaDanh_Modles> diaDanh_modles = new ArrayList<>();
            for (int i = 0 ; i < Logo_Diadanh.length ; i ++)
            {
                DiaDanh_Modles modles = new DiaDanh_Modles(Logo_Diadanh[i],Ten_Diadanh[i]);
                diaDanh_modles.add(modles);
            }

            // thiết kế list theo kiều ngang

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerDataAdapter(this, (ArrayList<DiaDanh_Modles>) diaDanh_modles));

    }

}
