package com.travel.dulichviet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
     private int id;
    public String DATABASE_NAME ="maps.sqlite" ;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

         mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    public void getBundle() {

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null) {
            id = bundle.getInt("i",0);
            Log.e("ID Map", String.valueOf(id));
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        getBundle();
        mMap = googleMap;

        database = Database.initDatabase(this, DATABASE_NAME);

        if (id != -1) {
            Cursor cursor = database.rawQuery("Select * from anh_viet", null);
            cursor.moveToPosition(id);
            MAPS m = new MAPS(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getDouble(3)
            );

            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(m.getN(), m.getE());
            mMap.addMarker(new MarkerOptions()
                    .position(sydney)
                    .title(m.getTen()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
        }
        else {
            LatLng sydney = new LatLng(21.582923, 105.696967);
            mMap.addMarker(new MarkerOptions()
                    .position(sydney)
                    .title("Hồ Núi Cốc"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
        }
        database.close();
    }
}
