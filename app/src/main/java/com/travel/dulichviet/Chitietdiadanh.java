package com.travel.dulichviet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chitietdiadanh extends AppCompatActivity {

    // mỗi lần thay đổi sql là phải lưu tên mới bởi vì nó tạo ra 1 sql giống y cái này

    public String DATABASE_NAME = "dulichviets.sqlite";
    public SQLiteDatabase database;
    ImageView img1;
    TextView tvTendiadanh;
    TextView tvMota;
    int idDiadanh =0;
    ImageButton btMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietdiadanh);
        img1 = findViewById(R.id.imgChitiet);
        tvTendiadanh = findViewById(R.id.txtTendiadanh);
        tvMota = findViewById(R.id.txtChitietMotadd);
        btMap = findViewById(R.id.btMap);

        getBundle();

        //  chuyển màn qua maps
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chitietdiadanh.this, MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("i",idDiadanh);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        loadData();
    }

    // get dữ liệu từ activity
    public void getBundle() {

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null) {
            idDiadanh = bundle.getInt("id",-1);
            Log.e("ID Nhận", String.valueOf(idDiadanh));
        }
    }

    public void loadData() {

            database = Database.initDatabase(this, DATABASE_NAME);
        @SuppressLint("Recycle") Cursor cursor = database.rawQuery("SELECT * FROM chitietdiadanh", null);

        if (idDiadanh == -1) {
            tvTendiadanh.setText("Không tồn tại");
        } else {
            cursor.moveToPosition(idDiadanh);

            ItemsChitietDiaDanh diaDanh = new ItemsChitietDiaDanh(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getBlob(3),
                    cursor.getBlob(4),
                    cursor.getBlob(5),
                    cursor.getBlob(6)
            );
            tvTendiadanh.setText(diaDanh.getTen());
            tvMota.setText(diaDanh.getMota());

            byte[] hinhAnh = diaDanh.getHinh1();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);
            img1.setImageBitmap(bitmap);
        }
    database.close();
        cursor.close();
    }


}
