package com.tripvn.dulichviet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview,recyclerview2;
    public SQLiteDatabase database;
    public String DATABASE_NAME = "databasetrip.sqlite";
    List<DiaDanh_Modles> listDiaDanh_noitieng,listDiaDanh_phobien;
    public String biendao = "SELECT * FROM diadanh_biendao";
    public String noitieng = "SELECT * FROM diadanh_noitieng";
    EditText Search;
    ImageButton btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Search = findViewById(R.id.editext_search);
        btnSearch = findViewById(R.id.btnsearch);
        recyclerview = findViewById(R.id.recyclerview1);
        recyclerview2 = findViewById(R.id.recyclerview2);


        ListNoiTieng(noitieng);
        ListBiendao(biendao);

        // bắt sự kiện imageButton search
        // m xử lý đoạn này đi
        /*
        Chỉ cần tìm dc trên có trong mảng A rồi cái số thứ tự i trong mảng nó sẽ là id của chính nó
        Nên chỉ cần tìm dc nó là gửi dc id của nó qua bên màn hình kia
        Làm sơ sài như này lại điểm thấp lắm
         */
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timKiem();
            }
        });
    }


    private void timKiem() {
        int flag = 0;
        Intent intent = new Intent(MainActivity.this, Chitietdiadanh.class);
        Bundle bundle = new Bundle();
        String A[] = {"Hồ Núi Cốc","Bà Nà","Bãi Dài","Biển Bình Tiên","Côn Đảo","Cù Lao Chàm","Cù Lao Xanh","Đảo Phú Quốc","Đồng Tháp","Vịnh Hạ Long","Vũng Tàu","Vịnh Lan Hạ","Phong Nha-Kẻ Bàng","Cao nguyên đá Đồng Văn","Hang SonDoong","Ghềnh đá dĩa","Làng chài An Bằng","Thác Bản Giốc","Đèo Hải Vân","Mù Cang Chải","Mộc Châu","Đà Lạt","Sa Pa","Kinh Đô Huế","Tràng An","Phố cổ Hội An","Cáp treo Vinpearl Nha Trang","Nha Trang"};
               for (int i = 0 ; i < A.length ; i ++)
               {
                   if(Search.getText().toString().equalsIgnoreCase(A[i])==true)
                   {

                       bundle.putInt("id",i);
                       startActivity(intent);
                       flag =1;
                   }
               }
               if (flag==0){
                   bundle.putInt("id",-1);
                   startActivity(intent);
               }

    }

    public void ListNoiTieng(String noitieng) {
        listDiaDanh_noitieng = new ArrayList<>();
        loadData(noitieng,listDiaDanh_noitieng);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview.setLayoutManager(layoutManager2);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(new RecyclerDataAdapter(this, listDiaDanh_noitieng));
    }
    public void ListBiendao(String biendao) {
        listDiaDanh_phobien = new ArrayList<>();
        loadData(biendao,listDiaDanh_phobien);
        LinearLayoutManager _layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview2.setLayoutManager(_layoutManager);
        recyclerview2.setHasFixedSize(true);
        recyclerview2.setAdapter(new RecyclerDataAdapter(this, listDiaDanh_phobien));
    }

    public void loadData(String str,List<DiaDanh_Modles> listDiaDanh){
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery(str,null);
        while (cursor.moveToNext()){
            listDiaDanh.add(new DiaDanh_Modles(
                    cursor.getInt(0),
                    cursor.getBlob(2),
                    cursor.getString(1)
            ));
        }
        cursor.close();
        database.close();
    }

}
