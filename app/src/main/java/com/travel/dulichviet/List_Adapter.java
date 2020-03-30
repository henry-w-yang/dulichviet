package com.travel.dulichviet;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class List_Adapter extends RecyclerView.Adapter<List_Adapter.ViewHolder> {

        ArrayList<DiaDanh_Modles> listDiaDanh;
        Context context;

        public List_Adapter(Context context, ArrayList<DiaDanh_Modles> mainModles)
        {
            this.context = context;
            this.listDiaDanh = mainModles;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //create view
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // set thuộc tính hình ảnh và tên địa danh
            DiaDanh_Modles DDanh = listDiaDanh.get(position);
            byte[] hinhAnh = DDanh.getLogo_Diadanh();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
            holder.item_image.setImageBitmap(bitmap);
//            holder.item_image.setImageResource(DiaDanh_Modle.get(position).getLogo_Diadanh());
            holder.item_title.setText(listDiaDanh.get(position).getTen_Diadanh());

        }

        @Override
        public int getItemCount() {
            return listDiaDanh.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView item_image;
            TextView item_title;
            public ViewHolder(@NonNull View itemView) {

                super(itemView);
               item_image = item_image.findViewById(R.id.item_image);
               item_title = item_title.findViewById(R.id.item_title);
            }
        }
    }
