package com.travel.dulichviet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class XemtatcaActivity extends AppCompatActivity {

    RecyclerView recyclerviewAll;
    SQLiteDatabase database;
    public String DATABASE_NAME ="dulichviets.sqlite" ;
    List<DiaDanh_Modles> listdiadanh;
    public String alldiadanh = "SELECT id,ten,mota,hinh2 FROM chitietdiadanh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemtatca);

        recyclerviewAll = findViewById(R.id.recycler_xemtatca);

        ListAllDiadanh(alldiadanh);
    }
        public void ListAllDiadanh (String biendao){
            listdiadanh = new ArrayList<>();

            loadData(biendao, listdiadanh);

            LinearLayoutManager _layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerviewAll.setLayoutManager(_layoutManager);
            recyclerviewAll.setHasFixedSize(true);// Fix về cùng kích thước giúp trượt mượt hơn
            recyclerviewAll.setAdapter(new RecyclerAdapterXemTatCa(this,listdiadanh));
        }

        public void loadData (String str, List < DiaDanh_Modles > listDiaDanh){

            database = Database.initDatabase(this,DATABASE_NAME);
            Cursor cursor = database.rawQuery(str, null);
            while (cursor.moveToNext()) {
                listDiaDanh.add(new DiaDanh_Modles(
                        cursor.getInt(0),
                        cursor.getBlob(3),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
            }
            database.close();
            cursor.close();
        }

    }
