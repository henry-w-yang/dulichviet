package com.travel.dulichviet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.DataViewHolder> {

    private List<DiaDanh_Modles> diaDanh_modles;
    private Context context;

    public RecyclerDataAdapter(Context context, List<DiaDanh_Modles> diaDanh_modles) {
        this.context = context;
        this.diaDanh_modles = diaDanh_modles;
    }

    @Override
    public int getItemCount() {
        return diaDanh_modles == null ? 0 : diaDanh_modles.size();
    }
    @Override
    public RecyclerDataAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerDataAdapter.DataViewHolder holder, int position) {
        String name = diaDanh_modles.get(position).getTen_Diadanh();
        holder.tenDiaDanh.setText(name);
        holder.logoDiaDanh.setImageResource(diaDanh_modles.get(position).getLogo_Diadanh());

    }

    /**
     * Data ViewHolder class.
     */
    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView tenDiaDanh;
        private ImageView logoDiaDanh;

        public DataViewHolder(View itemView) {
            super(itemView);

            tenDiaDanh = itemView.findViewById(R.id.item_title);
            logoDiaDanh = itemView.findViewById(R.id.item_image);
        }
    }
}

