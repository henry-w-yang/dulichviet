package com.travel.dulichviet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView1,recyclerView2;
    ArrayList<DiaDanh_Modles> datas;
    List_Adapter list_adapter;

    int image[] = {R.drawable.baner,R.drawable.banner,R.drawable.banner1,R.drawable.cave,R.drawable.sapa,R.drawable.sapadwzj};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1 = findViewById(R.id.recyclerview1);
//        recyclerView2 = findViewById(R.id.recyclerview2);


        // tạo mảng
            int[] Logo_Diadanh = {R.drawable.sapadwzj,R.drawable.sapa,
                    R.drawable.cave,R.drawable.image003,R.drawable.banner,R.drawable.banner1};
            String [] Ten_Diadanh = {"Cáp treo Vinpearl"," Nha Trang","Đà lạt","Hội An","SaPa","Tràng An"};

            datas = new ArrayList<>();

            for (int i = 0 ; i < Logo_Diadanh.length ; i ++)
            {
                DiaDanh_Modles diadanh_modles = new DiaDanh_Modles(Logo_Diadanh[i],Ten_Diadanh[i]);
                datas.add(diadanh_modles);
            }

            // thiết kế list theo hiều ngang

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        list_adapter =new List_Adapter(MainActivity.this,datas);
        recyclerView1.setAdapter(list_adapter);



    }

}
