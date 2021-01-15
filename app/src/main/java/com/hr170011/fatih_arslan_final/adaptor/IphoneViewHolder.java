package com.hr170011.fatih_arslan_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr170011.fatih_arslan_final.R;


public class IphoneViewHolder extends RecyclerView.ViewHolder {

    ImageView imgIphoneLogo;
    TextView txtIphoneAdi;
    TextView txtTarih;

    public IphoneViewHolder(@NonNull View cardView, IphoneAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgIphoneLogo = cardView.findViewById(R.id.imgIphoneLogo);
        txtIphoneAdi = cardView.findViewById(R.id.txtIphoneAdi);
        txtTarih = cardView.findViewById(R.id.txtTarih);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onClik(getAdapterPosition());
            }
        });

    }
}