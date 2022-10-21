package com.example.datgvtph20617fptpolyphuongnamlib.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datgvtph20617fptpolyphuongnamlib.R;


public class SachViewholder extends RecyclerView.ViewHolder {
    TextView tv_name_sach, tv_gia_thue, tv_loai_sach;
    ImageView img_delete_sach;
    View item_sach;
    public SachViewholder(@NonNull View itemView) {
        super(itemView);
        tv_name_sach = itemView.findViewById(R.id.tv_name_sach_frag_sach);
        tv_gia_thue = itemView.findViewById(R.id.tv_gia_thue_sach_frag_sach);
        tv_loai_sach = itemView.findViewById(R.id.tv_name_loai_sach_frag_sach);
        img_delete_sach = itemView.findViewById(R.id.img_delete_sach);
        item_sach = itemView.findViewById(R.id.item_sach_frag_sach);
    }
}

