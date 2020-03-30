package com.travel.dulichviet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterXemTatCa extends RecyclerView.Adapter<RecyclerAdapterXemTatCa.DataViewHolder> {

    private List<DiaDanh_Modles> listDiaDanh;
    private Context context;

    public RecyclerAdapterXemTatCa(Context mycontext, List<DiaDanh_Modles> mydiaDanh_modles) {
        this.context = mycontext;
        this.listDiaDanh = mydiaDanh_modles;
    }

    @Override
    public int getItemCount() {
        return listDiaDanh.size();
    }
    @Override
    public RecyclerAdapterXemTatCa.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_xem_all,parent,false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterXemTatCa.DataViewHolder holder, int position) {
        //tim ten va set ten
        String name = listDiaDanh.get(position).getTen_Diadanh();
        holder.tenDiaDanh.setText(name);
        // tìm mô tả và set mô tả
        holder.motaDiadanh.setText(listDiaDanh.get(position).getMota());

        // tim id
        int ID = listDiaDanh.get(position).getid_DiaDanh();
        holder.idItems = ID;

        DiaDanh_Modles diaDanh = listDiaDanh.get(position);

        // chuyen hinh anh sang kieu mang byte[] va dung bit map de set anh

        byte[]hinhAnh =diaDanh.getLogo_Diadanh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        holder.logoDiaDanh.setImageBitmap(bitmap);

    }

    /**
     * Data ViewHolder class.
     */
    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView tenDiaDanh,motaDiadanh;
        private ImageView logoDiaDanh;

        private int idItems;

        public DataViewHolder(View itemView) {
            super(itemView);

            tenDiaDanh = itemView.findViewById(R.id.item_titleAll);
            logoDiaDanh = itemView.findViewById(R.id.item_imageAll);
            motaDiadanh = itemView.findViewById(R.id.item_detailAll);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // gửi id và chuyển màn hình
                    Context context = v.getContext();
                    Intent intent = new Intent(context, Chitietdiadanh.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",idItems);
                    Log.e("id to chitiet : ", String.valueOf(idItems));
                    intent.putExtras(bundle);
                    context.startActivity(intent);


                }
            });
        }
    }
}

