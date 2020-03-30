package com.tripvn.dulichviet;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chitietdiadanh extends AppCompatActivity {

    // mỗi lần thay đổi sql là phải lưu tên mới bởi vì nó tạo ra 1 sql giống y cái này
    public String DATABASE_NAME = "databasetrip.sqlite";
    public SQLiteDatabase database;
    ImageView img1;
    TextView tvTendiadanh;
    TextView tvMota;
    int idDiadanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietdiadanh);
        img1 = findViewById(R.id.imgChitiet);
        tvTendiadanh = findViewById(R.id.txtTendiadanh);
        tvMota = findViewById(R.id.txtChitietMotadd);
// lấy dữ liệu từ MainAtivity
        getBundle();
        // tải dữ liệu trong sqlite
        loadData();

    }

    public void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle!= null) {
            idDiadanh = bundle.getInt("id", 0);
            Log.e("ID", String.valueOf(idDiadanh));

        }else{
            tvTendiadanh.setText("Không hợp lệ");
        }

    }

    public void loadData() {

        database = Database.initDatabase(this, DATABASE_NAME);
        @SuppressLint("Recycle") Cursor cursor = database.rawQuery("SELECT * FROM chitietdiadanh", null);

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
        byte [] hinhAnh = diaDanh.getHinh1();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        img1.setImageBitmap(bitmap);
    }

}
