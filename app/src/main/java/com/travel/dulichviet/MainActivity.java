package com.travel.dulichviet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview,recyclerview2;
    private static SQLiteDatabase database;
    private static final String DATABASE_NAME ="dulichviet.sqlite" ;
    List<DiaDanh_Modles> listDiaDanh_noitieng,listDiaDanh_phobien;
    public String phobien = "SELECT * FROM diadanh_phobien",noitieng = "SELECT * FROM diadanh_noitieng";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview1);
        recyclerview2 = findViewById(R.id.recyclerview2);
        ListNoiTieng(noitieng);
        ListPhoBien(phobien);

    }

    public void ListNoiTieng(String noitieng) {
        listDiaDanh_noitieng = new ArrayList<>();
        loadData(noitieng,listDiaDanh_noitieng);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview2.setLayoutManager(layoutManager2);
        recyclerview2.setHasFixedSize(true);
        recyclerview2.setAdapter(new RecyclerDataAdapter(this, listDiaDanh_noitieng));
    }
    public void ListPhoBien(String phobien) {
        listDiaDanh_phobien = new ArrayList<>();
        loadData(phobien,listDiaDanh_phobien);
        LinearLayoutManager _layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview.setLayoutManager(_layoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(new RecyclerDataAdapter(this, listDiaDanh_phobien));
    }

    public void loadData(String noitieng,List<DiaDanh_Modles> listDiaDanh_phobien){
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery(noitieng,null);
        while (cursor.moveToNext()){
            listDiaDanh_phobien.add(new DiaDanh_Modles(
                    cursor.getInt(0),
                    cursor.getBlob(3),
                    cursor.getString(1)
            ));
        }
    }

}
