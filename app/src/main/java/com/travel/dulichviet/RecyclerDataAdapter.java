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
        // Kiểm tra item view type, nếu là 1 thì inflate layout item_names.xml, 2 thì sử dụng item_names_female.
//        switch (viewType) {
//            case 1:
//                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
//                break;
//            case 2:
//                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name_female, parent, false);
//                break;
//            default:
//                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
//                break;
//        }
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

