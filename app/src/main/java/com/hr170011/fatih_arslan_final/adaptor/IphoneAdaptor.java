package com.hr170011.fatih_arslan_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr170011.fatih_arslan_final.R;
import com.hr170011.fatih_arslan_final.model.IphoneModel;
import com.hr170011.fatih_arslan_final.util.GlideUtil;



import java.util.List;

public class IphoneAdaptor extends RecyclerView.Adapter<IphoneViewHolder> {


    List<IphoneModel> iphonelar;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClik(int position);
    }
    public IphoneAdaptor(List<IphoneModel> iphonelar, Context context, OnItemClickListener listener) {
        this.iphonelar = iphonelar;
        this.context = context;
        this.listener =listener;
    }


    @NonNull
    @Override
    public IphoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_iphone,parent,false);
        return new IphoneViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull IphoneViewHolder viewHolder, int position) {

        viewHolder.txtTarih.setText(iphonelar.get(position).getIphoneTarihi());
        viewHolder.txtIphoneAdi.setText(iphonelar.get(position).getIphoneAdi());
        GlideUtil.resmiIndiripGoster(context,iphonelar.get(position).getLogoUrl(),viewHolder.imgIphoneLogo);

    }

    @Override
    public int getItemCount() {
        return iphonelar.size();
    }
}
